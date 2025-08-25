package gitproject.ConvertFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * 固定長の入力ファイルを可変長の出力ファイルに変換する
 */
public class ExLesson_05_ConvertFile {

	public static void main(String[] args) {
		// 引数の確認
		if (args.length < 2) {
			System.out.println("引数が足りません。ディレクトリとファイル名を指定してください。");
			return;
		}
		// TODO 存在しないファイル名のエラー処理
		String fileDirectory = args[0];
		String inputFileName = args[1];

		Pattern inputFileNamePattern = Pattern.compile(
				"^shain_(\\d{4})_([12])([12])([123])([01])\\.in(\\.zip)?$");

		Matcher inputFileNameMatcher = inputFileNamePattern.matcher(inputFileName);
		if (!inputFileNameMatcher.matches()) {
			System.out.println(inputFileName + "はファイル名の仕様と一致しません。");
			return;
		}
		// B: 1=MS932, 2=EUC-JP
		String charasetNum = inputFileNameMatcher.group(2);
		// C: 1=, , 2=\t
		String delimiterCharaNum = inputFileNameMatcher.group(3);
		// D: 1/2/3
		String fileNum = inputFileNameMatcher.group(4);
		// E: 0/1
		String zipNum = inputFileNameMatcher.group(5);
		// in / out
		String fileExtensionNum = inputFileNameMatcher.group(6);
		// zipが付いてる場合
		boolean hasZipExt = (fileExtensionNum != null);
		// E（圧縮有無）と拡張子「.zip」の整合チェックは、正規表現では縛れていない
		// Eが1（圧縮する）で拡張子にzipが付かなかった場合
		if ("1".equals(zipNum) && !hasZipExt) {
			System.out.println("圧縮する場合は入力ファイルの拡張子はzipである必要があります。");
			return;
			// Eが0（圧縮しない）で拡張子にzipが付いてる場合
		} else if ("0".equals(zipNum) && hasZipExt) {
			System.out.println("圧縮しない場合は入力ファイルの拡張子はzipは不要です。");
		}

		// [B]Shift-JIS(MS932)かEUC-JPか
		Charset charset = null;
		if (charasetNum.equals("1")) {
			charset = Charset.forName("MS932");
		} else if (charasetNum.equals("2")) {
			charset = Charset.forName("EUC-JP");
		} else {
			System.out.println("文字コード種別は1か2で設定してください。");
			return;
		}
		// [C]区切り種別
		String delimiterChara = null;
		if ("1".equals(delimiterCharaNum)) {
			delimiterChara = ",";
		} else if ("2".equals(delimiterCharaNum)) {
			delimiterChara = "\t";
		} else {
			System.out.println("区切り種別は1か2で設定してください。");
			return;
		}
		// [D]データ種別
		ShainBase shainBase = null;
		if (fileNum.equals("1")) {
			shainBase = new ShainBaseData();
		} else if (fileNum.equals("2")) {
			shainBase = new ShainAddressData();
		} else if (fileNum.equals("3")) {
			shainBase = new ShainSalaryData();
		} else {
			System.out.println("データ種別は1~3で設定してください。");
			return;
		}

		// [E]ZIP形式種別
		boolean isZip = false;
		if ("1".equals(zipNum)) {
			isZip = true;
		} else if ("0".equals(zipNum)) {
			isZip = false;
		} else {
			System.out.println("圧縮有無は1か0で設定してください。");
			return;
		}

		File inputFile = new File(fileDirectory, inputFileName);

		// 対象データクラスの項目、バイト数を取得
		List<SpecifyField> fileDataList = shainBase.getFileDataList();

		// ===== ZIP入力 =====
		if (isZip) {
			List<String> errorList = new ArrayList<String>();
			List<EntryBuffer> entryBufferList = new ArrayList<>();
			try (ZipInputStream zis = new ZipInputStream(new FileInputStream(inputFile))) {
				ZipEntry inEntry;
				while ((inEntry = zis.getNextEntry()) != null) {
					if (inEntry.isDirectory()) {
						zis.closeEntry();
						continue;
					}
			
					String outEntryName = inEntry.getName().replaceFirst("\\.in$", ".out");

					// このエントリ（ファイル）単位で全行読み込み
					BufferedReader br = new BufferedReader(
							new InputStreamReader(zis, charset));
					List<String> lineList = new ArrayList<>();
					String line;
					// まず全行読み
					while ((line = br.readLine()) != null) {
						lineList.add(line);
					}
					zis.closeEntry();

					// 1) 全行バイト数チェック
					List<String> byteErrorList = checkByteOfLine(
							lineList, charset, shainBase);
					// 1行でもズレがあれば、ここで全部出して終了
					if (!byteErrorList.isEmpty()) {
						for (String byteError : byteErrorList) {
							System.out.println(byteError);
						}
						// バイト数が1件でもズレたら以降の検証・出力は実施しない
						return;
					}

					// 2) バイト数OK → 内容チェックしつつ出力文字列を作成（行番号はそのエントリ内の番号）
					List<String> entryErrorList = new ArrayList<String>();
					StringBuilder entryOut = new StringBuilder(4096);

					for (int i = 0; i < lineList.size(); i++) {
						int lineNo = i + 1;
						byte[] byteLineArray = lineList.get(i).getBytes(charset);

						String valueLine = buildValueLine(
								lineList.get(i), fileDataList, charset, delimiterChara,
								shainBase, lineNo, entryErrorList, byteLineArray);

						if (valueLine != null) {
							entryOut.append(valueLine);
						}
					}

					if (!entryErrorList.isEmpty()) {
						// 1つでもエラーがあれば出力しないで終了
						for (String entryError : entryErrorList) {
							System.out.println(entryError);

						}
						return;
					}

					// 問題なければこのエントリ分をバッファ確保

					entryBufferList.add(new EntryBuffer(outEntryName, entryOut.toString().getBytes(charset)));

				}
			} catch (FileNotFoundException e) {
				System.out.println("指定されたファイルが見つかりません。");
				return;
			} catch (IOException e) {
				System.out.println("圧縮ファイルの変換でエラーが起きました。");

				return;
			}

			// 3) ここまで来たら全エントリOK → ZIPを書き出す
			String outputZipName = inputFileName.replace(".in.zip", ".out.zip");
			File outputZip = new File(fileDirectory, outputZipName);
			try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(outputZip))) {

				for (EntryBuffer entryBuffer : entryBufferList) {
					zos.putNextEntry(new ZipEntry(entryBuffer.name));
					zos.write(entryBuffer.data);
					zos.closeEntry();
				}
				System.out.println("圧縮ファイルの変換が完了しました。");
			} catch (IOException e) {
				System.out.println("圧縮ファイルの書き込みでエラーが起きました。");
				e.printStackTrace();
			}

			// ===== 通常ファイル入力 =====
		} else {
			String outputFileName = inputFileName.replace(".in", ".out");
			File outputFile = new File(fileDirectory, outputFileName);

			// ②行単位で読む
			try (BufferedReader br = new BufferedReader(
					// ①バイトファイルを読み、文字に変換
					new InputStreamReader(new FileInputStream(inputFile), charset))) {

				// まず全行読み
				List<String> lineList = new ArrayList<String>();
				String line;
				while ((line = br.readLine()) != null) {
					lineList.add(line);

				}

				// 1) 全行バイト数チェック
				List<String> byteErrorList = checkByteOfLine(
						lineList, charset, shainBase);
				if (!byteErrorList.isEmpty()) {
					for (String byteError : byteErrorList) {
						System.out.println(byteError);
					}
					return;
				}

				// 2) バイト数OKなら、ここで初めて各行の検証 & 連結
				StringBuilder outBuffer = new StringBuilder(8192);
				List<String> errorList = new ArrayList<>();
				// 行数
				for (int i = 0; i < lineList.size(); i++) {
					int lineNo = i + 1;
					// 1行をバイト配列で取得
					byte[] byteLineArray = lineList.get(i).getBytes(charset);
					String valueLine = buildValueLine(
							lineList.get(i), fileDataList, charset, delimiterChara,
							shainBase, lineNo, errorList, byteLineArray);

					if (valueLine != null) {
						outBuffer.append(valueLine);
					}
				}
				// エラーがあるなら全部出力して終了
				if (!errorList.isEmpty()) {
					// 1つでもエラーがあれば出力しないで終了
					for (String error : errorList) {
						System.out.println(error);

					}
					return;
				}
				// 3) エラーない場合ここで初めて出力ファイルを開いて書く
				try (BufferedWriter bw = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(outputFile), charset))) {
					bw.write(outBuffer.toString());
				}

				System.out.println("ファイルの変換が完了しました。");
			} catch (FileNotFoundException e) {
				System.out.println("ファイルが見つかりませんでした。");
			} catch (IOException e) {
				System.out.println("ファイルの変換でエラーが起きました。");
				e.printStackTrace();
			}

		}
	}

	/**
	 * 文字データをバイト配列にして文字単位で値を返す
	 * @param line
	 * @param fieldByteList
	 * @param charset
	 * @param delimiterChara
	 * @param maxByte
	 * @return
	 */
	private static String buildValueLine(
			String line,
			List<SpecifyField> fieldByteList,
			Charset charset,
			String delimiterChara, ShainBase shainBase, int lineNo, List<String> errorList, byte[] byteLineArray) {

		// 文字列を連結するために256文字分のバッファを確保
		StringBuilder sb = new StringBuilder(256);
		// Stringの文字を連結
		List<String> shainBaseDataList = ShainBase.getValueList(
				byteLineArray,
				fieldByteList, charset, shainBase, lineNo);

		List<String> lineErrorList = ShainBase.getErrorList(fieldByteList, shainBase, lineNo,
				shainBaseDataList);
		if (!lineErrorList.isEmpty()) {
			errorList.addAll(lineErrorList);
			return null;

		}
		// 問題なければ連結
		for (int i = 0; i < fieldByteList.size(); i++) {
			if (i > 0) {
				sb.append(delimiterChara);
			}
			sb.append(shainBaseDataList.get(i).trim());
		}

		sb.append("\r\n");

		return sb.toString();

	}

	/**
	 * 全行のバイト数をチェック（ズレがあればエラーメッセージを返す）
	 * @param line
	 * @param charset
	 * @param shainBase
	 * @return
	 */
	private static List<String> checkByteOfLine(List<String> lineList, Charset charset, ShainBase shainBase) {

		List<String> errorList = new ArrayList<String>();
		int i;
		for (i = 0; i < lineList.size(); i++) {
			int lineNo = i + 1;
			byte[] b = lineList.get(i).getBytes(charset);
			if (b.length != shainBase.getMaxByte()) {
				errorList.add(lineNo + "行目のバイト数が既定の" + shainBase.getMaxByte()
						+ "Bではないです。");
			}
		}

		return errorList;

	}
}
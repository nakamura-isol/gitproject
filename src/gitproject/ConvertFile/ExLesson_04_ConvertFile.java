package gitproject.ConvertFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * 固定長の入力ファイルを可変長の出力ファイルに変換する
 */
public class ExLesson_04_ConvertFile {

	public static void main(String[] args) {
		// 引数の確認
		if (args.length < 2) {
			System.out.println("引数が足りません。ディレクトリとファイル名を指定してください。");
			return;
		}
		String fileDirectory = args[0];
		String inputFile = args[1];

		String outputFile = inputFile.replace(".in", ".out");

		// Shift-JIS(MS932)かEUC-JPか
		Charset charset = null;
		String charasetNum = inputFile.substring(11, 12);
		if (charasetNum.equals("1")) {
			charset = Charset.forName("MS932");
		} else if (charasetNum.equals("2")) {
			charset = Charset.forName("EUC-JP");
		} else {
			System.out.println("1か2で文字コードを指定してください。");
			return;
		}

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream(fileDirectory + "\\" + inputFile), charset));
				BufferedWriter bw = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(fileDirectory + "\\" + outputFile), charset))) {
			String line;
			// 項目のバイト位置と長さ
			int employeeIdStart = 0, employeeIdLength = 4;
			int nameStart = 4, nameLength = 20;
			int ageStart = 24, ageLength = 3;
			int telephoneNumStart = 27, telephoneNumLength = 13;
			while ((line = br.readLine()) != null) {

				// バイト配列に変換
				byte[] byteArray = line.getBytes(charset);

				// 最大40バイト数なので超えていないかチェック
				if (byteArray.length > 41) {
					byte[] trimmedArray = new byte[40];
					System.arraycopy(byteArray, 0, trimmedArray, 0, 40);
					byteArray = trimmedArray;
				}
				System.out.println(byteArray.length);
				List<String> employeeDataList = new ArrayList<>();

				String employeeId = new String(getSplitedByteArray(byteArray,
						employeeIdStart, employeeIdLength), charset);
				String name = new String(getSplitedByteArray(byteArray, nameStart, nameLength),
						charset);
				String age = new String(getSplitedByteArray(byteArray, ageStart, ageLength),
						charset);
				String telephoneNum = new String(getSplitedByteArray(byteArray, telephoneNumStart,
						telephoneNumLength),
						charset);
				employeeDataList.add(employeeId);
				employeeDataList.add(name);
				employeeDataList.add(age);
				employeeDataList.add(telephoneNum);

				// 可変長形式に
				for (int i = 0; i < employeeDataList.size(); i++) {
					employeeDataList.set(i, employeeDataList.get(i).trim());
				}

				// カンマ区切りかタブ区切りか
				String delimiterChara = null;
				String delimiterCharaNum = inputFile.substring(12, 13);
				if (delimiterCharaNum.equals("1")) {
					delimiterChara = ",";
				} else if (delimiterCharaNum.equals("2")) {
					delimiterChara = "\t";
				}
				// 可変長形式
				for (int i = 0; i < employeeDataList.size(); i++) {
					if (i == employeeDataList.size() - 1) {
						bw.write(employeeDataList.get(i));
					} else {
						bw.write(employeeDataList.get(i) + delimiterChara);
					}

				}
				bw.write("\r\n");

			}
			System.out.println("変換が完了しました。");
		} catch (FileNotFoundException e) {
			System.out.println("ファイルが見つかりませんでした。");
		} catch (IOException e) {
			System.out.println("何かしらのエラーが起きました。");
		}
	}

	/**
	 * byte配列の一部を取り出す
	 * @param byteArray
	 * @param byteStart
	 * @return
	 */
	public static byte[] getSplitedByteArray(byte[] byteArray, int byteStart, int byteLength) {
		byte[] splitedByteArray = new byte[byteLength];
		for (int i = 0; i < byteLength; i++) {
			// 範囲外アクセスを防ぐ
			if (byteStart + i < byteArray.length) {

				splitedByteArray[i] = byteArray[byteStart + i];
			} else {
				// 長さ不足分はスペースで埋める（ASCIIコードの半角スペースのバイト値）
				splitedByteArray[i] = 0x20;
			}

		}
		return splitedByteArray;
	}

}

package gitproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * SQLチェックプログラム
 */
public class Lesson49 {
	public static final String SELECT_FROM_CHECK_TXT = "select_fromCheck.txt";
	public static final String WHERE_CHECK_TXT = "whereCheck.txt";

	public static void main(String[] args) {
		List<String> select_fromCheckTxtList = getTxtList(SELECT_FROM_CHECK_TXT);
		List<String> whereCheckTxtList = getTxtList(WHERE_CHECK_TXT);
		System.out.println("SQLを入力してください。");
		String line;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			line = br.readLine();
			checkInputedSql(line, select_fromCheckTxtList, whereCheckTxtList);

		} catch (IOException e) {
			System.out.println("読み込みに失敗しました。");
			e.printStackTrace();
		}
	}

	/**
	 * 引数のテキストファイルを読み込み、リストで返す
	 * @return
	 */
	private static List<String> getTxtList(String txtName) {
		List<String> txtList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(txtName))) {
			String line;
			while ((line = br.readLine()) != null) {
				// 空行はスキップ
				if (line.trim().isEmpty())
					continue;
				// 空白やタブで分割して追加
				String[] parts = line.trim().split("\\s+");
				for (String part : parts) {
					txtList.add(part);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("ファイルが見つかりませんでした。");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("読み込みエラーが発生しました。");
			e.printStackTrace();
		}
		return txtList;
	}

	/**
	 * 入力値がSQLの構文になってるかチェックする
	 * @param line
	 * @return
	 */
	// 
	private static void checkInputedSql(String line, List<String> select_fromCheckTxtList,
			List<String> whereCheckTxtList) {

		// select_fromCheckTxtListの1行だけを取得
		String[] select_fromCheckTxtColumns = select_fromCheckTxtList.get(0).split("　");
		String[] whereCheckTxtColumns = whereCheckTxtList.get(0).split("　");
		// ①SELECT句とFROM句の構造をチェック
		// 入力値をリスト化
		List<String> inputedSqlList = createInputedList(line);
		if (inputedSqlList == null) {
			System.out.println("SELECT FROMの構文になっていません。");
			return;
		}
		// 入力全体を1つの文字列にして文法チェック（大文字小文字無視）
		String lowerSql = line.trim().toLowerCase();
		if (!lowerSql.startsWith("select") || !lowerSql.contains("from")) {
			System.out.println("SELECT FROMの構文になっていません。");
			return;
		}
		// テーブル名チェック
		// FROMの位置を探す
		int fromIndex = -1;
		for (int i = 0; i < inputedSqlList.size(); i++) {
			if (inputedSqlList.get(i).equalsIgnoreCase("from")) {
				fromIndex = i;
				break;
			}
		}
		String tableName = inputedSqlList.get(fromIndex + 1);
		if (!(tableName.equalsIgnoreCase("USERDATA"))) {
			System.out.println("存在しないテーブルが指定されています。");
			return;
		}
		// ①-②SELECT対象カラムのチェック
		String selectedColumn = inputedSqlList.get(1);
		// 取得カラムが＊でない場合、一つか複数を取得する
		if (!(selectedColumn.equals("*"))) {
			// カラム一覧を全角スペースで分割してチェック
			boolean exists = false;
			// SELECT対象カラムを複数入力された場合
			String[] inputedSelectedColumns = selectedColumn.split(",");
			// 入力されたカラム名達がselect_fromCheckTxtにあるものか
			for (int i = 0; i < inputedSelectedColumns.length; i++) {
				// SQLのSELECT句で指定されたカラム名の前後に不要な空白があった場合、それを取り除く処理
				String inputedSelectedColumn = inputedSelectedColumns[i].trim();
				for (int j = 0; j < select_fromCheckTxtColumns.length; j++) {
					if (inputedSelectedColumn.equals(select_fromCheckTxtColumns[j])) {
						exists = true;
						break;
					}
				}
			}
			if (!exists) {
				System.out.println("指定されたカラムは存在しません。");
				return;
			}
		}
		// ②WHERE句がある場合
		// WHERE句の位置を探す
		int whereIndex = -1;
		for (int i = 0; i < inputedSqlList.size(); i++) {
			if (inputedSqlList.get(i).equalsIgnoreCase("where")) {
				whereIndex = i;
				break;
			}
		}

		// WHEREの後の要素だけを取り出す
		List<String> conditionList = inputedSqlList.subList(whereIndex + 1, inputedSqlList.size());
		// "AND" で分割する
		// 最終的な条件セット（複数条件）を保存するリスト。
		List<List<String>> conditions = new ArrayList<>();
		// 一時的に1つの条件（カラム・演算子・値の3つ）を保持。
		List<String> currentCondition = new ArrayList<>();
		// トークンを1つずつ見て、ANDかORが出たら条件を1つ確定
		for (String token : conditionList) {
			//もしANDかORがきてcurrentConditionの要素が3つだったらそれで1つとして、conditionsに入れる。
			if (token.equalsIgnoreCase("AND") || token.equalsIgnoreCase("OR")) {
				// "名前", "=", "'中村'"
				if (currentCondition.size() == 3) {
					conditions.add(currentCondition);
				} else {
					System.out.println("WHERE句の条件が誤っています。");
					return;
				}
				// 次の条件を新しく入れるためにリストを初期化
				currentCondition = new ArrayList<>();
			} else {
				// 条件一つだった場合
				currentCondition.add(token);
			}
		}
		// 最後の条件（ANDがない一番最後の条件）はループ終了後に追加
		if (currentCondition.size() == 3) {
			conditions.add(currentCondition);
		} else {
			System.out.println("WHERE句の条件が不正です。");
			return;
		}
		// 各条件を検証
		for (List<String> condtion : conditions) {
			String whereColumn = condtion.get(0);
			String operator = condtion.get(1);
			String value = condtion.get(2);
			// カラム名の存在チェック
			boolean foundWhereColumn = false;
			for (String validWhereCol : whereCheckTxtColumns) {
				if (whereColumn.equals(validWhereCol)) {
					foundWhereColumn = true;
					break;
				}
			}
			if (!foundWhereColumn) {
				System.out.println("条件句のカラムは存在しません。");
				return;
			}

			// 条件カラムが名前、住所、職業だった場合、演算子が=か!=出なければエラー
			if ((whereColumn.equals("名前") || whereColumn.equals("住所") || whereColumn.equals("職業"))
					&& !((operator.equals("=") || operator.equals("!=")))) {
				System.out.println("条件句が誤っています。");
				return;
			}
			if ((whereColumn.equals("名前") || whereColumn.equals("住所") || whereColumn.equals("職業"))
					&& !(value.startsWith("'") && value.endsWith("'"))) {
				System.out.println("文字列に''が付いていません。");
				return;
			}
			// 条件カラムがID、年齢だった場合
			// 比較対象の値が数値かチェック
			String regex = "^[0-9]+$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(value);
			if ((whereColumn.equals("ID") || whereColumn.equals("年齢")) && !(matcher.find())) {
				System.out.println("条件句のデータと演算子が合っていません。");
				return;
			}
		}

		System.out.println("SQLは正しいです。");

	}

	/**
	 * 半角スペース・全角スペース・カンマを区切りとして扱い、カンマはトークンとして残す
	 * 入力値をリスト化する
	 * @return
	 */
	private static List<String> createInputedList(String line) {
		List<String> inputedList = new ArrayList<>();
		if (line == null || line.trim().isEmpty())
			return null;
		// 正規表現でトークン抽出
		// 単語またはカンマ(,)を別トークンとして抽出（空白は無視）
		// 例: SELECT 年齢, 名前 → ["SELECT", "年齢", ",", "名前"]
		String regex = "[^ 　,]+|,";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(line);
		while (matcher.find()) {
			inputedList.add(matcher.group());
		}
		// トークン数が4未満ならnull（簡易チェック）
		if (inputedList.size() < 4)
			return null;
		return inputedList;
	}

}

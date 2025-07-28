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
public class Lesson50 {
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
			printUserData(line, whereCheckTxtList);
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
	 * 
	 * @param inputedSqlList 入力されたSQL構文のリスト
	 * @return [0] 条件リスト（List<List<String>>）, [1] 論理演算子リスト（List<String>）
	 */
	private static Object[] parseWhereConditions(List<String> inputedSqlList) {
		List<List<String>> conditions = new ArrayList<>();
		List<String> logicalOperators = new ArrayList<>();
		int whereIndex = -1;
		for (int i = 0; i < inputedSqlList.size(); i++) {
			if (inputedSqlList.get(i).equalsIgnoreCase("where")) {
				whereIndex = i;
				break;
			}
		}
		if (whereIndex == -1)
			return new Object[] { conditions, logicalOperators };
		List<String> conditionList = inputedSqlList.subList(whereIndex + 1, inputedSqlList.size());
		List<String> currentCondition = new ArrayList<>();

		for (String token : conditionList) {
			if (token.equalsIgnoreCase("AND") || token.equalsIgnoreCase("OR")) {
				if (currentCondition.size() == 3) {
					conditions.add(currentCondition);
					logicalOperators.add(token.toUpperCase());
					currentCondition = new ArrayList<>();
				} else {
					return null;
				}
			} else {
				currentCondition.add(token);
			}
		}
		if (currentCondition.size() == 3) {
			conditions.add(currentCondition);
		} else if (!currentCondition.isEmpty()) {
			return null;
		}
		return new Object[] { conditions, logicalOperators };
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
		// 全角スペースで分割
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
		// 文字列の前後の空白（スペース・タブ・改行など）を除去して、小文字に変換
		String lowerSql = line.trim().toLowerCase();
		if (!lowerSql.startsWith("select") || !lowerSql.contains("from")) {
			System.out.println("SELECT FROMの構文になっていません。");
			return;
		}

		if (!lowerSql.contains("userdata")) {
			System.out.println("存在しないテーブルが指定されています。");
			return;
		}
		// ①SELECTカラムの存在チェック 
		
		List<String> selectedColumns = new ArrayList<>();
		int fromIndex = -1;
		for (int i = 0; i < inputedSqlList.size(); i++) {
			if (inputedSqlList.get(i).equalsIgnoreCase("from")) {
				fromIndex = i;
				break;
			}
		}
		// SELECT句カラム部分は1からfromIndexの手前まで
		for (int i = 1; i < fromIndex; i++) {
			String token = inputedSqlList.get(i);
			if (!token.equals(",")) {
				selectedColumns.add(token.trim());
			}
		}
	
		String selectedColumn = selectedColumns.get(0);
		// SELECT対象のカラムが＊でない場合、一つでも複数でも対応できるように配列でセレクトカラムを持つ
		if (!selectedColumn.equals("*")) {
			boolean exists = false;

			for (String inputColumns : selectedColumns) {
				for (String txtColumns : select_fromCheckTxtColumns) {
					if (inputColumns.equals(txtColumns)) {
						exists = true;
						break;
					}
				}
				if (!exists) {
					System.out.println("指定されたカラムは存在しません。");
					return;
				}
			}
		}
		// ②WHERE句がある場合
		if (inputedSqlList.contains("where") || inputedSqlList.contains("WHERE")) {
			Object[] parsedWhereCondition = parseWhereConditions(inputedSqlList);
			if (parsedWhereCondition == null) {
				System.out.println("WHERE句の条件が不正です。");
				return;
			}

			List<List<String>> conditions = (List<List<String>>) parsedWhereCondition[0];

			// 各条件を検証
			for (List<String> cond : conditions) {
				String whereColumn = cond.get(0);
				String operator = cond.get(1);
				String value = cond.get(2);
				// 条件カラムの存在チェック
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
		}

	}

	/**
	 * 半角スペース・全角スペース・カンマを区切りとして扱い、カンマはトークンとして残す
	 * 入力値をリスト化する
	 * @param line
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

	/**
	 * ユーザーデータを表示する
	 * @param userData
	 */
	private static void printUserData(String line, List<String> whereCheckTxtList) {
		// 入力値をリスト化
		List<String> inputedSqlList = createInputedList(line);
		// ヘッダー行（カラム名）を取得
		String[] headerColumns = whereCheckTxtList.get(0).split("　");
		// セレクトカラムを取得して格納するリスト!!!!!!
		List<String> selectedColumns = new ArrayList<>();
		int fromIndex = -1;
		for (int i = 0; i < inputedSqlList.size(); i++) {
			if (inputedSqlList.get(i).equalsIgnoreCase("from")) {
				fromIndex = i;
				break;
			}
		}
		// SELECT句カラム部分は1からfromIndexの手前まで
		for (int i = 1; i < fromIndex; i++) {
			String token = inputedSqlList.get(i);
			if (!token.equals(",")) {
				selectedColumns.add(token.trim());
			}
		}
		// selectedColumnsに正規化されたカラム名が入るので、チェックや出力に使う!!!!!

		//		 セレクトカラムを取得

		String selectedColumn = selectedColumns.get(0);

		// 取得対象カラムのインデックス一覧
		List<Integer> selectedIndexes = new ArrayList<>();
		// セレクトカラムが*の場合
		if (selectedColumns.size() == 1 && selectedColumns.get(0).equals("*")) {
			for (int i = 0; i < headerColumns.length; i++) {
				selectedIndexes.add(i);
			}
		} else {
			for (String col : selectedColumns) {
				for (int i = 0; i < headerColumns.length; i++) {
					if (col.equals(headerColumns[i])) {
						selectedIndexes.add(i);
						break;
					}
				}
			}
		}
		// WHERE句の条件と論理演算子のリスト
		// ANDとORの論理演算子を扱えるようにconditionsとlogicalOperatorsを分けて処理。
		List<List<String>> whereConditions = new ArrayList<>();
		// WHERE句に複数の条件があるとき、それぞれの条件をつなぐANDやORの「論理演算子（ロジック演算子）」を保持するために用意
		List<String> whereLogicalOperators = new ArrayList<>();

		// WHERE句の位置を探す
		int whereIndex = -1;
		for (int i = 0; i < inputedSqlList.size(); i++) {
			if (inputedSqlList.get(i).equalsIgnoreCase("where")) {
				whereIndex = i;
				break;
			}
		}

		// WHERE句の条件の解析
		if (whereIndex != -1) {
			Object[] parsedWhereConditions = parseWhereConditions(inputedSqlList);
			if (parsedWhereConditions == null)
				return;
			whereConditions = (List<List<String>>) parsedWhereConditions[0];
			whereLogicalOperators = (List<String>) parsedWhereConditions[1];
		}

		boolean currentMatch = false;
		// データ行（1行目はヘッダー）
		for (int i = 1; i < whereCheckTxtList.size(); i++) {
			String[] row = whereCheckTxtList.get(i).split("　");
			// 条件なしなら常に一致（WHERE句の評価結果を一時的に保持するための変数）
			Boolean result = null;
			for (int j = 0; j < whereConditions.size(); j++) {
				List<String> condition = whereConditions.get(j);
				String whereColumn = condition.get(0);
				String whereOperator = condition.get(1);
				String whereValue = condition.get(2);

				int headerColumnIndex = -1;
				for (int k = 0; k < headerColumns.length; k++) {
					if (headerColumns[k].equals(whereColumn)) {
						headerColumnIndex = k;
						break;
					}
				}
				if (headerColumnIndex == -1) {
					result = false;
					break;
				}

				String columnValue = row[headerColumnIndex];
				// 1つの条件（カラムの値、演算子、条件値）を評価
				currentMatch = evaluateCondition(columnValue, whereOperator, whereValue);

				// 条件を評価（AND/OR）
				// 最初の条件結果を評価の起点として使うための処理
				// 2つ目以降はANDやORを使って、resultを更新していく仕組み
				if (j == 0) {
					result = currentMatch;
				} else {
					String logic = whereLogicalOperators.get(j - 1);
					if (logic.equals("AND")) {
						result = result && currentMatch;
					} else if (logic.equals("OR")) {
						result = result || currentMatch;
					}
				}
			}
			// データ出力
			// この行を出力対象とするかどうかの最終判断
			if (result != null && result) {
				for (int index : selectedIndexes) {
					System.out.print(row[index] + "\t");
				}
				System.out.println();
			}
		}
	}

	/**
	 * 1つの条件（カラムの値、演算子、条件値）を評価して true/false を返す
	 * @param columnValue
	 * @param operator
	 * @param whereValue
	 * @return
	 */
	private static boolean evaluateCondition(String columnValue, String whereOperator, String whereValue) {
		// 文字列だった場合
		boolean currentMatch = false;
		if (whereValue.startsWith("'") && whereValue.endsWith("'")) {
			String stringWhereValue = whereValue.substring(1, whereValue.length() - 1);
			switch (whereOperator) {
			case "=":
				currentMatch = columnValue.equals(stringWhereValue);
				break;
			case "!=":
				currentMatch = !columnValue.equals(stringWhereValue);
				break;
			default:
				currentMatch = false;
			}
			// 数値だった場合
		} else {
			try {
				int intColumnValue = Integer.parseInt(columnValue);
				int intWhereValue = Integer.parseInt(whereValue);
				switch (whereOperator) {
				case "=":
					currentMatch = intColumnValue == intWhereValue;
					break;
				case "!=":
					currentMatch = intColumnValue != intWhereValue;
					break;
				case ">":
					currentMatch = intColumnValue > intWhereValue;
					break;
				case "<":
					currentMatch = intColumnValue < intWhereValue;
					break;
				case ">=":
					currentMatch = intColumnValue >= intWhereValue;
					break;
				case "<=":
					currentMatch = intColumnValue <= intWhereValue;
					break;
				default:
					currentMatch = false;
				}
			} catch (NumberFormatException e) {
				currentMatch = false;
			}
		}

		return currentMatch;
	}

}

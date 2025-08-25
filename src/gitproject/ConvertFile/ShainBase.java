package gitproject.ConvertFile;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 */
public abstract class ShainBase {

	public static final String shainBaseData = "shainBaseData.txt";
	public static final String shainAddressData = "shainAddressData.txt";
	public static final String shainSalaryData = "shainSalaryData.txt";

	// 使い回し用にプリコンパイル
	// 空欄の正規表現
	private static final Pattern EMPTY_VALUE_PATTERN = Pattern.compile("^[ \\u3000]*$");
	// 全角の正規表現
	private static final Pattern HALF_WIDTH_ONLY_PATTERN = Pattern.compile("^[\\u0020-\\u007E\\uFF61-\\uFF9F]+$");
	// 半角の正規表現
	private static final Pattern FULL_WIDTH_ONLY_PATTERN = Pattern.compile("^[^\\u0020-\\u007E\\uFF61-\\uFF9F]+$");

	public abstract int getMaxByte();

	public abstract List<SpecifyField> getFileDataList();

	/**
	 * データ（値）をバイト単位で切り出して文字列のリストで返す
	 * @param byteArray
	 * @param fileDataList
	 * @param charset
	 * @param shainBase
	 * @return
	 */
	public static List<String> getValueList(byte[] byteArray, List<SpecifyField> fileDataList,
			Charset charset, ShainBase shainBase, int lineNo) {
		List<String> valueList = new ArrayList<>();

		for (SpecifyField fileData : fileDataList) {
			// 指定されたバイト範囲を新しい配列にコピー
			byte[] newByteArray = new byte[fileData.getFieldLength()];
			System.arraycopy(byteArray, fileData.getFieldStartIndex(), newByteArray, 0, fileData.getFieldLength());
			// 指定された文字コード（Charset）でバイト配列を文字列にデコード
			String value = new String(newByteArray, charset);
			valueList.add(value);

		}
		return valueList;
	}

	/**
	 * 取得した必須項目が空白か判定する
	 * @param value
	 * @return
	 */
	public static boolean isFieldValueRequired(String value, SpecifyField field) {
		boolean isEmpty = false;
		// 全角半角スペース、空文字を拾う
		Matcher emptyValueMatcher = EMPTY_VALUE_PATTERN.matcher(value);
		boolean fieldValueRequired = field.getFieldValueRequired();
		if (emptyValueMatcher.matches()) {
			if (fieldValueRequired) {
				return isEmpty = true;
			}

		}
		return isEmpty;

	}

	/**
	 * 全角（半角）の項目で、値の大きさが合っているか判定する
	 * @param value
	 * @param fieldByte
	 * @return
	 */
	public static boolean isFieldValueHalfWidthOnly(String value, SpecifyField field) {
		boolean isWrongCharaWidth = false;
		value = value.trim();
		// フィールドの設定が全角（半角）、値も全角（半角）ならOK
		// 半角のフィールドの場合
		if (field.getHalfWidth()) {
			Matcher halfWidthMatcher = HALF_WIDTH_ONLY_PATTERN.matcher(value);
			if (!halfWidthMatcher.matches()) {
				return isWrongCharaWidth = true;
			}
			// 全角のフィールドの場合
		} else {
			Matcher fullWidthMatcher = FULL_WIDTH_ONLY_PATTERN.matcher(value);
			if (!fullWidthMatcher.matches()) {
				return isWrongCharaWidth = true;
			}
		}
		return isWrongCharaWidth;

	}

	public boolean validateField(String value, SpecifyField field) {
		return false;
		// 既定は何もしない（サブクラスで必要な項目だけ検証する）
	}

	/**
	 * valueListの中身を確認してエラー文を返す
	 * @return
	 */
	public static List<String> getErrorList(List<SpecifyField> fileDataList, ShainBase shainBase,
			int lineNo, List<String> valueList) {
		List<String> errorList = new ArrayList<>();
		for (int i = 0; i < fileDataList.size(); i++) {
			SpecifyField field = fileDataList.get(i);
			String value = valueList.get(i);

			// 必須を埋めてるかチェック
			boolean isEmpty = isFieldValueRequired(value, field);
			if (isEmpty) {
				errorList.add(lineNo + "行目の必須項目である" + field.getFieldName() +
						"が空欄です。");
				// 空欄だったら形式チェックしない
				break;
			}
			// 全角半角を守っているかチェック
			boolean isWrongCharaWidth = isFieldValueHalfWidthOnly(value, field);
			if (isWrongCharaWidth) {
				errorList.add(lineNo + "行目の" + field.getFieldName() +
						"全角（半角）の形式が不正です。");
			}

			// ファイル別項目の形式チェック（基本データの生年月日、住所データの電話番号）
			boolean isWrongFormat = shainBase.validateField(value, field);
			if (isWrongFormat) {
				errorList.add(lineNo + "行目の" + field.getFieldName() +
						"の形式が不正です。");
			}

		}

		return errorList;

	}
}

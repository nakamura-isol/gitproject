package gitproject.ConvertFile;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 社員基本データクラス
 */
public class ShainBaseData extends ShainBase {

	public static final String SHAIN_BASE_DATA = "shainBaseData.txt";

	public static final String EMPLOYEE_ID = "社員番号";
	public static final String NAME = "名前";
	public static final String SEX = "性別";
	public static final String AGE = "年齢";
	public static final String DATE_OF_BARTH = "生年月日";

	// フィールド定義
	// 社員番号
	int employeeIdStart = 0, employeeIdLength = 4;
	// 名前
	int nameStart = employeeIdLength, nameLength = 20;
	// 性別
	int sexStart = employeeIdLength + nameLength, sexLength = 1;
	// 年齢
	int ageStart = employeeIdLength + nameLength + sexLength, ageLength = 3;
	// 生年月日
	int dateOfBirthStart = employeeIdLength + nameLength + sexLength + ageLength, dateOfBirthLength = 10;

	// 最大バイト数
	int maxByte = employeeIdLength + nameLength + sexLength + ageLength + dateOfBirthLength;

	/**
	 * 最大バイト数を返す
	 * @return
	 */
	@Override
	public int getMaxByte() {
		return maxByte;
	}

	@Override
	public List<SpecifyField> getFileDataList() {
		List<SpecifyField> shainBaseDataList = new ArrayList<>();
		shainBaseDataList.add(new SpecifyField(EMPLOYEE_ID, employeeIdStart,
				employeeIdLength, true, true));
		shainBaseDataList.add(new SpecifyField(NAME, nameStart, nameLength, true, false));
		shainBaseDataList.add(new SpecifyField(SEX, sexStart, sexLength, true, true));
		shainBaseDataList.add(new SpecifyField(AGE, ageStart, ageLength, true, true));
		shainBaseDataList.add(new SpecifyField(DATE_OF_BARTH, dateOfBirthStart,
				dateOfBirthLength, true, true));

		return shainBaseDataList;
	}

	/**
	 * 生年月日の形式をチェックする
	 */
	public boolean validateField(String value, SpecifyField field) {
		boolean isWrong = false;
		if (field.getFieldName().equals(DATE_OF_BARTH)) {

			Pattern dateOfBirthPattern = Pattern.compile(
					"^\\d{4}/\\d{2}/\\d{2}$");

			Matcher dateOfBirthNameMatcher = dateOfBirthPattern.matcher(value);
			if (!dateOfBirthNameMatcher.matches()) {

				return isWrong = true;
			}
		}
		return isWrong;

	}

}

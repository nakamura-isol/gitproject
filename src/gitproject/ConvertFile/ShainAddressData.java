package gitproject.ConvertFile;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 社員住所データクラス
 */
public class ShainAddressData extends ShainBase {

	public static final String SHAIN_ADDRESS_DATA = "shainAddressData.txt";

	public static final String EMPLOYEE_ID = "社員番号";
	public static final String POSTAL_CODE = "郵便番号";
	public static final String PREFECTURE = "都道府県";
	public static final String ADDRESS_LINE1 = "市区町村番地";
	public static final String ADDRESS_LINE2 = "ビル・マンション名";
	public static final String PHONE_NUM = "電話番号";

	// 社員番号
	int employeeIdStart = 0, employeeIdLength = 4;
	// 郵便番号
	int postalCodeStart = employeeIdLength, postalCodeLength = 8;
	// 都道府県
	int prefectureStart = employeeIdLength + postalCodeLength;
	int prefectureLength = 8;
	// 市区町村番地
	int addressLine1Start = employeeIdLength + postalCodeLength + prefectureLength,
			addressLine1Length = 120;
	// ビル・マンション名
	int addressLine2Start = employeeIdLength + postalCodeLength + prefectureLength + addressLine1Length,
			addressLine2Length = 120;
	// 電話番号
	int phoneNumStart = employeeIdLength + postalCodeLength + prefectureLength + addressLine1Length
			+ addressLine2Length,
			phoneNumLength = 13;
	// 最大バイト数
	int maxByte = employeeIdLength + postalCodeLength + prefectureLength + addressLine1Length
			+ addressLine2Length
			+ phoneNumLength;

	@Override
	public int getMaxByte() {
		return maxByte;
	}

	@Override
	public List<SpecifyField> getFileDataList() {
		List<SpecifyField> shainAddressFieldList = new ArrayList<>();
		shainAddressFieldList.add(new SpecifyField(EMPLOYEE_ID, employeeIdStart, employeeIdLength, true, true));
		shainAddressFieldList.add(new SpecifyField(POSTAL_CODE, postalCodeStart, postalCodeLength, true, true));
		shainAddressFieldList.add(new SpecifyField(PREFECTURE, prefectureStart, prefectureLength, true, false));
		shainAddressFieldList
				.add(new SpecifyField(ADDRESS_LINE1, addressLine1Start, addressLine1Length, true, false));
		shainAddressFieldList
				.add(new SpecifyField(ADDRESS_LINE2, addressLine2Start, addressLine2Length, false, false));
		shainAddressFieldList.add(new SpecifyField(PHONE_NUM, phoneNumStart, phoneNumLength, true, true));
		return shainAddressFieldList;
	}

	/**
	 * 電話番号の形式をチェックする
	 */
	public boolean validateField(String value, SpecifyField field) {
		boolean isWrong = false;
		if (field.getFieldName().equals(PHONE_NUM)) {

			Pattern phoneNumPattern = Pattern.compile(
					"^\\d{3}-\\d{3,4}-\\d{4}$");
			value = value.trim();
			Matcher phoneNumMatcher = phoneNumPattern.matcher(value);
			if (!phoneNumMatcher.matches()) {
				return isWrong = true;
			}
		}
		return isWrong;

	}

}

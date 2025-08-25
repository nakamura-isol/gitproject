package gitproject.ConvertFile;

import java.util.ArrayList;
import java.util.List;

/**
 * 社員給与データクラス
 */
public class ShainSalaryData extends ShainBase {

	public static final String SHAIN_SALARY_DATA = "shainSalaryData.txt";

	public static final String EMPLOYEE_ID = "社員番号";
	public static final String BASE_SALARY = "基本給";
	public static final String QUALIFICATION_ALLOWANCE = "資格手当";
	public static final String POSITION_ALLOWANCE = "役職手当";
	public static final String TECHNICAL_ALLOWANCE = "技術手当";
	public static final String TEMPORARY_TRANSFER_ALLOWANCE = "出向手当";

	// 社員番号
	int employeeIdStart = 0, employeeIdLength = 4;
	// 基本給
	int baseSalaryStart = employeeIdLength, baseSalaryLength = 9;
	// 資格手当
	int qualificationAllowanceStart = employeeIdLength + baseSalaryLength, qualificationAllowanceLength = 9;

	// 役職手当
	int positionAllowanceStart = employeeIdLength + baseSalaryLength + qualificationAllowanceLength,
			positionAllowanceLength = 9;
	// 技術手当
	int technicalAllowanceStart = employeeIdLength + baseSalaryLength + qualificationAllowanceLength
			+ positionAllowanceLength, technicalAllowanceLength = 9;

	// 出向手当
	int temporaryTransferAllowanceStart = employeeIdLength + baseSalaryLength + qualificationAllowanceLength
			+ positionAllowanceLength + technicalAllowanceLength, temporaryTransferAllowanceLength = 9;
	// 最大バイト数
	int maxByte = employeeIdLength + baseSalaryLength + qualificationAllowanceLength + positionAllowanceLength
			+ technicalAllowanceLength + temporaryTransferAllowanceLength;

	public int getMaxByte() {
		return maxByte;
	}

	@Override
	public List<SpecifyField> getFileDataList() {
		List<SpecifyField> shainSalaryDataList = new ArrayList<>();
		shainSalaryDataList.add(new SpecifyField(EMPLOYEE_ID, employeeIdStart, employeeIdLength, true, true));
		shainSalaryDataList.add(new SpecifyField(BASE_SALARY, baseSalaryStart, baseSalaryLength, true, true));
		shainSalaryDataList
				.add(new SpecifyField(QUALIFICATION_ALLOWANCE, qualificationAllowanceStart,
						qualificationAllowanceLength, false, true));
		shainSalaryDataList
				.add(new SpecifyField(POSITION_ALLOWANCE, positionAllowanceStart, positionAllowanceLength, false,
						true));
		shainSalaryDataList
				.add(new SpecifyField(TECHNICAL_ALLOWANCE, technicalAllowanceStart, technicalAllowanceLength,
						false, true));
		shainSalaryDataList
				.add(new SpecifyField(TEMPORARY_TRANSFER_ALLOWANCE, temporaryTransferAllowanceStart,
						temporaryTransferAllowanceLength, false, true));

		return shainSalaryDataList;
	}

}

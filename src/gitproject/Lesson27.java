package gitproject;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ロッカー管理プログラム
 */
public class Lesson27 {
	// ロッカーの状態を管理する3次元配列 (0:空き, 1:使用中)
	// クラスの静的フィールドとして宣言し、プログラム全体で共有する
	private static int[][][] lockerStatus;

	public static void main(String[] args) {
		// ロッカーの状態配列を初期化（すべて0: 空き）
		// Javaのint配列はデフォルトで0で初期化されるため、明示的なループは不要
		// 縦に4個、横に10個並んだロッカーが5レーンある
		lockerStatus = new int[5][10][4];

		// ※テスト
		lockerStatus[0][0][0] = 1;
		lockerStatus[4][9][3] = 0;
		System.out.println("ロッカーの識別番号を入力してください。");
		Scanner sc = new Scanner(System.in);
		String inputedLockerNum = sc.next();
		checkLockerStatus(inputedLockerNum);
		sc.close();
	}

	/**
	 * ロッカーが空いてるかを調べる
	 * @param inputedLockerNum
	 * @param lockerNum
	 */
	private static void checkLockerStatus(String inputedLockerNum) {
		//1~9の数字で始まり、その後に任意の2桁の数字が続く正規表現
		String regex = "^\\d{3}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(inputedLockerNum);
		if (!matcher.matches()) {
			System.out.println("3桁の半角数字で入力してください。");
			return;
		}
		int laneIndex = Character.getNumericValue(inputedLockerNum.charAt(0));
		int colIndex = Character.getNumericValue(inputedLockerNum.charAt(1));
		int rowIndex = Character.getNumericValue(inputedLockerNum.charAt(2));
		// 000~493まで
		if (!(laneIndex >= 0 && laneIndex < 5 && colIndex >= 0 && colIndex < 10 && rowIndex >= 0 && rowIndex < 4)) {
			System.out.println(inputedLockerNum + "は存在しません。");
			return;
		}
		int currentLockerStatus = lockerStatus[laneIndex][colIndex][rowIndex];
		if (currentLockerStatus == 0) {
			System.out.println(inputedLockerNum + "のロッカーは使用できます。");
		} else if (currentLockerStatus == 1) {
			System.out.println(inputedLockerNum + "のロッカーは使用中です。");
		}
	}
}

import java.util.Random;
import java.util.Scanner;

/**
 * 丁半プログラム
 */
public class Lesson40_4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int syoji = 100;
		while (true) {
			System.out.println("掛け金を入力してください。");
			String inputBet = scanner.next();
			if ("end".equals(inputBet)) {
				System.out.println("勝負を終了します。");
				break;
			}
			int bet;
			try {
				bet = Integer.valueOf(inputBet);
			} catch (NumberFormatException e) {
				System.out.println("数値を正しく入力してください。");
				continue;
			}
			if (bet <= 0 || bet > syoji) {
				System.out.println("掛け金は1以上、所持金以内で入力してください。");
				continue;
			}
			String inputTyouHan;
			while (true) {
				System.out.println("丁か半かを選んでください。");
				inputTyouHan = scanner.next();
				if ("丁".equals(inputTyouHan) || "半".equals(inputTyouHan)) {
					break;
				}
				System.out.println("『丁』か『半』を入力してください。");
			}
			String resultTyouHan = getTyouHan();
			System.out.println(resultTyouHan);
			syoji = getSyoji(syoji, Integer.valueOf(inputBet), inputTyouHan, resultTyouHan);
			if (inputTyouHan.equals(resultTyouHan)) {
				System.out.println("掛けに勝ったので所持金が倍になります。所持金：" + syoji);
			} else {
				System.out.println("掛けに負けたので所持金が引かれます。所持金：" + syoji);
			}
			if (0 >= syoji) {
				System.out.println("所持金が0以下なので勝負を終了します。");
				break;
			}
		}
	}

	/**
	 * 丁半を返す
	 * @return
	 */
	private static String getTyouHan() {
		Random random = new Random();
		// 1から6の乱数を生成
		int diceRoll = random.nextInt(6) + 1;
		if (diceRoll % 2 == 0) {
			return "丁";
		} else {
			return "半";
		}
	}
	/**
	 * 丁半結果の所持金を返す
	 */
	private static int getSyoji(int syoji, int bet, String inputTyoHan, String resultTyouHan) {
		if (inputTyoHan.equals(resultTyouHan)) {
			return syoji += bet * 2;
		} else {
			return syoji -= bet;
		}
	}

}

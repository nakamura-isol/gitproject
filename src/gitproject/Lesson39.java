import java.util.Random;
import java.util.Scanner;

/**
 * 50%の確率で丁、50%の確率で半を出力する
 */
public class Lesson39_2 {

	public static void main(String[] args) {
		System.out.println("Enterを押す度丁か半かを返します。");
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String input = scanner.nextLine();
			if ("end".equals(input)) {
				break;
			}
			printResult();
		}
		System.out.println("丁半を終了します。");
	}

	/**
	 * 丁か半かを出す
	 * @return
	 */
	private static void printResult() {
		Random random = new Random();
		// 1から6の乱数を生成
		int diceRoll = random.nextInt(6) + 1;
		if (diceRoll % 2 == 0) {
			System.out.println("丁");
		} else {
			System.out.println("半");
		}
	}
}

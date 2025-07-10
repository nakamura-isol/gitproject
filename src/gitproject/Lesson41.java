package gitproject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lesson41 {

	public static void main(String[] args) {
		List<Integer> tintiroList = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			if (kobore()) {
				// こぼれた場合はnull
				tintiroList.add(null);
			} else {
				// 通常の賽の目
				tintiroList.add(tintiro());
			}
		}
		for (Integer tintiro : tintiroList) {
			if (tintiro == null) {
				System.out.print("こぼれ ");
			} else {
				System.out.print(tintiro + " ");
			}
		}
	}

	/**
	 * 1%の確率でこぼす
	 * @return
	 */
	public static boolean kobore() {
		Random random = new Random();
		// 1から100の乱数を生成
		int kobore = random.nextInt(100) + 1;
		// 1の場合は何もしない (数字が出力されない)
		return kobore == 1;
	}

	/**
	 * 賽の目を返す
	 * @return
	 */
	private static int tintiro() {
		Random random = new Random();
		// 1から6の乱数を生成
		int diceRoll = random.nextInt(6) + 1;
		return diceRoll;
	}

}

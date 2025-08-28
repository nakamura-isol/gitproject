package javadrill.exercise012.question003;

public class MathUtils {
	/**
	 * 素数判定メソッド（素数は1とその数自体以外に約数を持たない数）
	 * @param num
	 * @return
	 */
	static boolean isPrime(int num) {
		// 1は素数ではない
		if (num <= 1) {
			return false;
		}
		// 1より大きい数字でその数の平方根（自分自身の数）以外で割り切れたら素数ではない
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;

			}
		}
		return true;
	}

	/**
	 * 階乗計算メソッド（階乗はその数から1までの全ての正整数を掛けたもの）
	 * 「再帰」を使った階乗計算メソッド
	 * @param num
	 * @return
	 */
	static int factorial(int num) {
		if (num == 0 || num == 1) {
			return 1;
		}
		return num * factorial(num - 1);
	}

	/**
	 * フィボナッチ数列判定メソッド（フィボナッチ数列は前の2つの数の和が次の数になる数列）
	 * 与えられた数がフィボナッチ数列に含まれるかどうかを判定するメソッド
	 * @param num
	 * @return
	 */
	static boolean isFibonacci(int num) {
		// 負数はフィボナッチ数列に含まれない
		if (num < 0) {
			return false;
		}
		int a = 0;
		int b = 1;
		// numが0以上で、0と一致したらtrue
		while (a <= num) {
			if (a == num) {
				return true;
			}
			// 一時的に保存
			int temp = a + b;
			a = b;
			b = temp;
		}
		return false;
	}
}

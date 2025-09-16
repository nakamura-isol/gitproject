package javadrill.exercise006;

/**
 * ネストされたfor文を使用して、1から100までの素数を表示するプログラム
 */
public class Question008 {

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			boolean isPrime = false;
			isPrime = checkPrime(i);
			if (isPrime == false) {
				// 素数ではない場合はスキップ
				continue;
			} else {
				System.out.println(i);
			}

		}

	}

	/**
	 * 素数判定メソッド
	 * @param num
	 * @return
	 */
	private static boolean checkPrime(int num) {
		// 1以下は素数ではない
		if (num <= 1) {
			return false;
		}
		// 2は素数
		if (num == 2) {
			return true;
		}

		// 2からnumの平方根までの数で割り切れるか確認
		// 2からnumの平方根まで調べる
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}

}

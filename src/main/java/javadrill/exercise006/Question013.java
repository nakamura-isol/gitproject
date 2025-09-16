package javadrill.exercise006;

public class Question013 {

	public static void main(String[] args) {
		doubleValue(2);

	}

	/**
	 * 2の倍数を10回繰り返し表示する
	 */
	private static void doubleValue(int num) {
		int count = 0;
		while (count < 10) {
			   int multipleOfTwo = 2 * (count + 1); // 2の倍数を計算
			System.out.println(multipleOfTwo);
			count++;
		}

	}
}

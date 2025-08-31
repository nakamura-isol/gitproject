package javadrill.exercise004.question044;

/**
 * 3×5の2次元整数配列の要素数をプログラムで確認する
 */
public class Question044 {

	public static void main(String[] args) {
		int[][] array = {
				{ 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10, }, { 1, 2, 3, 4, 5 }
		};

		System.out.println(countElements(array));
		System.out.println(extraCountElements(array));

	}

	/**
	 * 
	 * @param array
	 * @return
	 */
	private static int extraCountElements(int[][] array) {

		return array.length * array[0].length;
	}

	/**
	 * 
	 * @param array
	 * @return
	 */
	private static int countElements(int[][] array) {
		int iCount = 0;
		int jCount = 0;
		// 配列matrixの要素数を計算。行数と列数の積
		for (int i = 0; i < array.length; i++) {
			iCount++;
		}

		for (int j = 0; j < array[0].length; j++) {
			jCount++;
		}

		return jCount * iCount;
	}

}

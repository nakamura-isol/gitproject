package javadrill.exercise008.question019;

public class Question019 {

	public static void main(String[] args) {
		int[] array = { 1, 6, 100, 89, 4, 38, 90, 3, };
		int max = findMax(array);
		System.out.println(max);
	}

	/**
	 * 整数型の配列を引数として受け取り、その配列内の最大値を返す
	 * @return
	 */
	public static int findMax(int[] array) {
		// 配列が空の場合、最大値は定義できないため、エラーコードとして -1 を返す。
		if (array == null || array.length == 0) {
			return -1;
		}

		// 最大値の初期化
		int max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				// より大きい値が見つかった場合、最大値を更新
				max = array[i];
			}
		}

		return max;
	}
}

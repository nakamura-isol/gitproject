package javadrill.exercise004;

/**
 * 2次元整数配列内の最小値と最大値を見つ
 */
public class Question042 {

	public static void main(String[] args) {
		int[][] matrix = {
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }
		};
		// 配列内の最初の要素を最小値と最大値の初期値として設定
		int min = matrix[0][0];
		int max = matrix[0][0];

		// 配列内の各要素と比較し、最小値および最大値を更新します
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (min > matrix[i][j]) {
					min = matrix[i][j];
				}
				if (max < matrix[i][j]) {
					max = matrix[i][j];
				}
			}
		}
		System.out.println(max);
		System.out.println(min);

	}

}

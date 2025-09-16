package javadrill.exercise004;

/**
 * 2次元整数配列が与えられた場合、特定の要素の値を取得する
 */
public class Question038 {

	public static void main(String[] args) {
		int[][] matrix = {
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }
		};
		// matrix[1][2] の要素を取得
		int element = matrix[1][2];

		// 取得した要素の値を表示
		System.out.println("matrix[1][2] の値は: " + element);

	}

}

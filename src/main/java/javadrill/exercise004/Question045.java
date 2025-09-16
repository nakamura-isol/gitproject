package javadrill.exercise004;

/**
 * 2次元整数配列のすべての要素に順番に値を代入する
 */
public class Question045 {

	public static void main(String[] args) {
		int[][] grid = new int[4][4];
		int num = 1;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = num;
				num++;
			}
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j]+"\t");
			}
			System.out.println();
		}
	}

}

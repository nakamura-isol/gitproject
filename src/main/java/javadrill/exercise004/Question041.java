package javadrill.exercise004;
/**
 * 2次元整数配列の行ごとの合計値を計算して、それらの値を新しい配列に格納する
 */
public class Question041 {

	public static void main(String[] args) {
		int[][] matrix = {
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }
		};
		
		 // 行ごとの合計値を格納する新しい配列の宣言
        int[] rowSums = new int[matrix.length];
		
		for(int i=0;i<matrix.length;i++) {
			int sum = 0;
		 for(int j=0;j<matrix[i].length;j++) {
			 sum += matrix[i][j];
		 }
		 rowSums[i] = sum;
		}
		
		  // 各行の合計値を出力
        for (int i = 0; i < rowSums.length; i++) {
            System.out.println("Row " + i + " の合計値: " + rowSums[i]);
        }

	}

}

package gitproject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ビンゴカード用配列を作成する関数
 */
public class Lesson44 {

	public static void main(String[] args) {
		int col = 5;
		int row = 5;
		//ビンゴカード表示
		int[][] bingo = createBingo(col, row);
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				System.out.print(bingo[i][j] + "\t");
			}
			System.out.println();
		}
	}

	/**
	 * ビンゴカードを生成して返す	
	 */
	private static int[][] createBingo(int col, int row) {
		
		int[][] bingo = new int[col][row];
		// 各列ごとに異なる範囲で値を設定
		//iは横、jは縦
		for (int i = 0; i < col; i++) {
			// 各列の「開始数字」を決める（iは横だから15を乗算して1を足す）
			int start = i * 15 + 1;
			//シャッフルするためListで持つ
			List<Integer> numList = new ArrayList<>();
			for (int k = 0; k < col; k++) {
				numList.add(start + k);
			}
			Collections.shuffle(numList);
			// 各列から5個を抽出して縦に詰める
			for (int j = 0; j < row; j++) {
				bingo[j][i] = numList.get(j);
			}

		}
		bingo[2][2] = 0;
		return bingo;
	}
}

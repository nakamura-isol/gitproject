package gitproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ビンゴカード用配列を作成する関数
 */
public class Lesson44 {

	public static void main(String[] args) {
		int row = 5;
		int col = 5;
		// ビンゴカード表示
		// 外のiは行（縦）の処理をしてる。中のjは列（横）の処理（移動）したい。
		int[][] bingo = createBingo(row, col);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(bingo[i][j] + "\t");
			}
			System.out.println();
		}
	}

	/**
	 * ビンゴカードを生成して返す	
	 */
	private static int[][] createBingo(int row, int col) {

		int[][] bingo = new int[row][col];
		// 各列ごとに異なる範囲で値を設定
		// iは縦、jは横に移動する
		// 列ごとに処理
		for (int j = 0; j < col; j++) {
			// 各列の「開始数字」を決める
			int start = j * 15 + 1;
			List<Integer> numList = new ArrayList<>();
			// 1列につき15個の数字を作る（連番を作る処理）
			for (int k = 0; k < 15; k++) {
				numList.add(start + k);
			}
			// シャッフルして各列の1~15の数字をランダムに
			Collections.shuffle(numList);
			// 各列から5個を抽出して行方向（縦）に詰める
			for (int i = 0; i < row; i++) {
				bingo[i][j] = numList.get(i);
			}

		}
		bingo[2][2] = 0;
		return bingo;
	}
}

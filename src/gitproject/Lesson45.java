package gitproject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/**
 * ビンゴカード使用プログラム
 */
public class Lesson45 {
	static int col = 5;
	static int row = 5;

	public static void main(String[] args) {

		// カード作成
		int[][] bingoCard = createBingo(col, row);
		int inputNum = 0;
		// 最初のカードを表示
		printBingo(bingoCard);
		while (true) {
			System.out.println("数値を入力してください。");
			if (!("end".equals(String.valueOf(inputNum)))) {
				Scanner scanner = new Scanner(System.in);
				inputNum = scanner.nextInt();
				// 穴を開ける
				punchBingo(inputNum, bingoCard);
				// 再表示
				printBingo(bingoCard);
			} else {
				break;
			}
		}
		System.out.println("終了します。");
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
		//真ん中には100を与える
		bingo[2][2] = 100;
		return bingo;
	}

	/**
	 * ビンゴカードを表示する
	 */
	private static void printBingo(int[][] bingo) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (bingo[i][j] == 100) {
					System.out.print("◎" + "\t");
				} else if (bingo[i][j] == 0) {
					System.out.print("○" + "\t");
				} else {
					System.out.print(bingo[i][j] + "\t");
				}
			}
			System.out.println();
		}
		int reachCount = getReachCount(bingo);
		int bingoCount = getBingoCount(bingo);
		System.out.println("リーチ数：" + reachCount);
		System.out.println("ビンゴ数：" + bingoCount);
	}

	/**
	 * カードに穴開ける
	 * @param num
	 */
	private static void punchBingo(int num, int[][] bingo) {
		//入力値とビンゴカードの数が一致したら0にする
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (bingo[i][j] == num) {
					bingo[i][j] = 0;
				}
			}
		}
	}

	/**
	 * リーチ数を返す
	 * @return
	 */
	private static int getReachCount(int[][] bingo) {
		int reachCount = 0;
		// 横のチェック（行）
		for (int i = 0; i < row; i++) {
			int marked = 0;
			int empty = 0;
			for (int j = 0; j < col; j++) {
				//0を空いたマスとする
				if (bingo[i][j] == 0 || bingo[i][j] == 100) {
					marked++;
				} else {
					empty++;
				}

			}
			if (marked == 4 && empty == 1) {
				reachCount++;
			}
		}
		// 縦のチェック（列）
		for (int j = 0; j < row; j++) {
			int marked = 0;
			int empty = 0;
			for (int i = 0; i < col; i++) {
				if (bingo[i][j] == 0 || bingo[i][j] == 100) {
					marked++;
				} else {
					empty++;
				}
			}
			if (marked == 4 && empty == 1) {
				reachCount++;
			}
		}
		// 斜め（左上→右下）
		int marked1 = 0;
		int empty1 = 0;
		for (int i = 0; i < 5; i++) {
			//斜めは一次元と二次元のインデックスが
			//対角線上のマス目は、行と列のインデックスが同じになる
			if (bingo[i][i] == 0 || bingo[i][i] == 100) {
				marked1++;
			} else {
				empty1++;
			}
		}
		if (marked1 == 4 && empty1 == 1) {
			reachCount++;
		}
		// 斜め（右上→左下）
		int marked2 = 0;
		int empty2 = 0;
		for (int i = 0; i < 5; i++) {
			if (bingo[i][4 - i] == 0 || bingo[i][4 - i] == 100) {
				marked2++;
			} else {
				empty2++;
			}
		}
		if (marked2 == 4 && empty2 == 1) {
			reachCount++;
		}
		return reachCount;
	}

	/**
	 * ビンゴ数を返す
	 * @param bingo
	 * @return
	 */
	private static int getBingoCount(int[][] bingo) {
		int bingoCount = 0;
		// 横のチェック（行）
		for (int i = 0; i < row; i++) {
			int marked = 0;
			int empty = 0;
			for (int j = 0; j < col; j++) {

				if (bingo[i][j] == 0) {
					marked++;
				} else {
					empty++;
				}
			}
			if (marked == 5) {
				bingoCount++;
			}
		}
		// 縦のチェック（列）
		for (int j = 0; j < row; j++) {
			int marked = 0;
			int empty = 0;
			for (int i = 0; i < col; i++) {
				if (bingo[i][j] == 0 || bingo[i][j] == 100) {
					marked++;
				} else {
					empty++;
				}
			}
			if (marked == 5) {
				bingoCount++;
			}
		}

		// 斜め（左上→右下）
		int marked1 = 0;
		int empty1 = 0;
		for (int i = 0; i < 5; i++) {
			if (bingo[i][i] == 0 || bingo[i][i] == 100) {
				marked1++;
			} else {
				empty1++;
			}
		}
		if (marked1 == 5) {
			bingoCount++;
		}
		// 斜め（右上→左下）
		int marked2 = 0;
		int empty2 = 0;
		for (int i = 0; i < 5; i++) {
			if (bingo[i][4 - i] == 0 || bingo[i][4 - i] == 100) {
				marked2++;
			} else {
				empty2++;
			}
		}
		if (marked2 == 5) {
			bingoCount++;
		}
		return bingoCount;
	}

}

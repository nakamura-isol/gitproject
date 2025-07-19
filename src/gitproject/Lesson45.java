package gitproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * ビンゴカード使用プログラム
 */
public class Lesson45 {
	static int row = 5;
	static int col = 5;

	public static void main(String[] args) {
		// カード作成
		int[][] bingoCard = createBingo(row, col);

		// 最初のカードを表示
		printBingo(bingoCard);
		while (true) {
			System.out.println("数値を入力してください。");
			Scanner scanner = new Scanner(System.in);
			// next()ではなく、nextLine()にすることでEnterのみを正しく検知できるようになる
			String input = scanner.nextLine();
			if ("end".equals(input)) {
				break;
			}
			// Enterを押下された場合
			if (input.isEmpty()) {
				printBingo(bingoCard);
				// 以降の処理はスキップ
				continue;
			}
			try {
				int inputNum = Integer.parseInt(input);
				// 穴を開ける
				punchBingo(inputNum, bingoCard);
				// 再表示
				printBingo(bingoCard);
			} catch (NumberFormatException e) {
				System.out.println("正しい数値を入力してください。");
			}
		}

		System.out.println("終了します。");

	}

	/**
	 * ビンゴカードを生成して返す	
	 */
	private static int[][] createBingo(int row, int col) {
		int[][] bingo = new int[row][col];
		// iは縦方向、jは横方向
		for (int j = 0; j < row; j++) {
			// 各列の「開始数字」を決める
			int start = j * 15 + 1;
			List<Integer> numList = new ArrayList<>();
			for (int k = 0; k < 15; k++) {
				numList.add(start + k);
			}
			Collections.shuffle(numList);
			// 各列から5個を抽出して行方向（縦）に詰める
			for (int i = 0; i < col; i++) {
				bingo[i][j] = numList.get(i);
			}
		}
		// 真ん中には100を与える
		bingo[2][2] = 100;
		return bingo;
	}

	/**
	 * ビンゴカードを表示する
	 */
	private static void printBingo(int[][] bingo) {
		// iは縦、jは横に移動する
		// iのループで罫線とビンゴの値を出力する
		for (int i = 0; i < row; i++) {
			// 1. 上部の罫線を出力
			for (int j = 0; j < col; j++) {
				System.out.print("----");
			}
			//改行
			System.out.println();

			// 2. ビンゴの値を出力
			for (int j = 0; j < col; j++) {
				// 列の罫線
				System.out.print("|");
				if (bingo[i][j] == 100) {
					// "\t"：複数の値が「横に揃えて」表示される
					System.out.print("◎" + "\t");
				} else if (bingo[i][j] == 0) {
					System.out.print("○" + "\t");
				} else {
					System.out.print(bingo[i][j] + "\t");
				}
			}
			// 最後の列（一番右の）の罫線を出力
			System.out.print("|");

			//改行
			System.out.println();
		}
		// 最後の行の下部の罫線を出力
		for (int j = 0; j < col; j++) {
			System.out.print("----");
		}

		//改行
		System.out.println();
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
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
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
			for (int j = 0; j < col; j++) {
				// 0を空いたマスとするし、100はフリースポット
				if (bingo[i][j] == 0 || bingo[i][j] == 100) {
					marked++;
				}
			}
			if (marked == 4) {
				reachCount++;
			}
		}
		// 縦のチェック（列）
		for (int j = 0; j < col; j++) {
			int marked = 0;
			for (int i = 0; i < row; i++) {
				if (bingo[i][j] == 0 || bingo[i][j] == 100) {
					marked++;
				}
			}
			if (marked == 4) {
				reachCount++;
			}
		}
		// 斜め（左上→右下）
		int marked1 = 0;
		for (int i = 0; i < 5; i++) {
			//斜めは一次元と二次元のインデックスが
			//対角線上のマス目は、行と列のインデックスが同じになる
			if (bingo[i][i] == 0 || bingo[i][i] == 100) {
				marked1++;
			}
		}
		if (marked1 == 4) {
			reachCount++;
		}
		// 斜め（右上→左下）
		int marked2 = 0;
		for (int j = 0; j < 5; j++) {
			if (bingo[j][4 - j] == 0 || bingo[j][4 - j] == 100) {
				marked2++;
			}
		}
		if (marked2 == 4) {
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
			for (int j = 0; j < col; j++) {
				if (bingo[i][j] == 0 || bingo[i][j] == 100) {
					marked++;
				}
			}
			if (marked == 5) {
				bingoCount++;
			}
		}
		// 縦のチェック（列）
		for (int j = 0; j < row; j++) {
			int marked = 0;
			for (int i = 0; i < col; i++) {
				if (bingo[i][j] == 0 || bingo[i][j] == 100) {
					marked++;
				}
			}
			if (marked == 5) {
				bingoCount++;
			}
		}
		// 斜め（左上→右下）
		int marked1 = 0;
		for (int i = 0; i < 5; i++) {
			if (bingo[i][i] == 0 || bingo[i][i] == 100) {
				marked1++;
			}
		}
		if (marked1 == 5) {
			bingoCount++;
		}

		// 斜め（右上→左下）
		int marked2 = 0;
		for (int i = 0; i < 5; i++) {
			if (bingo[i][4 - i] == 0 || bingo[i][4 - i] == 100) {
				marked2++;
			}
		}
		if (marked2 == 5) {
			bingoCount++;
		}
		return bingoCount;
	}

}

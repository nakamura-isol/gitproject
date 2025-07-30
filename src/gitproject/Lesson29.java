package gitproject;

/**
 * 右下が直角になる三角形を●で作る
 */
public class Lesson29 {

	public static void main(String[] args) {
		// 外側のループは行数を制御(i=0から3まで、合計4行)
		for (int i = 0; i < 4; i++) {
			// 内側のループ1は、空白の数を制御
			// 各行で表示する空白の数は、(4-1)-i個
			for (int j = 0; j < (3 - i); j++) {
				System.out.print("　");
			}

			// 内側のループ2は、●の数を制御
			// 各行で表示する●の数は、i+1個
			for (int k = 0; k <= i; k++) {
				System.out.print("●");
			}

			System.out.println();
		}

	}

}

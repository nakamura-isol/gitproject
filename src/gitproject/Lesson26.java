package gitproject;

/**
 * 九九の表を出力する
 */
public class Lesson26 {

	public static void main(String[] args) {
		createTimesTables();
	}

	/**
	 * 九九の表を作る
	 * @return
	 */
	private static void createTimesTables() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				// 値を出力後に罫線
				System.out.print(i * j + "|" + "\t");

			}
			// 改行
			System.out.println();
			// 罫線
			System.out.println("-----------------------------------");
		}
	}
}

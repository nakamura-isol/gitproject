package gitproject;

/**
 * 左下が直角になる三角形を●で作る
 */
public class Lesson28 {
	public static void main(String[] args) {
		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < i + 1; j++) {

				System.out.print("●");

			}

			System.out.println();

		}

	}
}

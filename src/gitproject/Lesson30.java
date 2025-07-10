import java.io.File;
import java.util.Scanner;
/**
 * 指定されたファイルが存在するか確認し、結果を出力する
 */
public class Lesson30 {

	public static void main(String[] args) {
		System.out.println("確認したいファイルパスを指定してください。");
		Scanner scanner = new Scanner(System.in);
		String imputFilePath = scanner.nextLine();
		 // 確認するファイルのパスを指定する
		File file = new File(imputFilePath);

		// ファイルの存在を確認する
		if (file.exists()) {
			System.out.println("ファイルが存在します。");
		} else {
			System.out.println("ファイルが存在しません。");
		}
	}

}

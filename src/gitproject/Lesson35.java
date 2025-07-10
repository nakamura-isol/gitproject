package gitproject;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * テキストファイルに追記する
 */
public class Lesson35 {

	public static void main(String[] args) {
		System.out.println("読み込むファイルのパスを入力してください。");
		Scanner scanner = new Scanner(System.in);
		String filePath = scanner.nextLine();
		File file = new File(filePath);
		String input;
		try {
			if (file.exists()) {
				// FileWriterクラスのオブジェクトを生成する
				FileWriter fileWriterFile = new FileWriter(file, true);
				System.out.println("ファイルに入力が追記されます。");

				// PrintWriterクラスのオブジェクトを生成する
				PrintWriter pw = new PrintWriter(new BufferedWriter(fileWriterFile));

				while (true) {
					input = scanner.nextLine();
					pw.println(input);
					if (input.equals("end")) {
						break;
					}
				}
				// ファイルを閉じる
				pw.close();
			} else {
				System.out.println("ファイルが見つかりませんでした。");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * テキストファイルに一行ずつ出力する
 */
public class Lesson33 {

	public static void main(String[] args) {
		System.out.println("入力値がファイルに書き込まれます。");
		Scanner scanner = new Scanner(System.in);
		String input;
		String filePath = "C:\\Users\\highe\\OneDrive\\ドキュメント\\課題\\Lesson33.txt";
		
		// ファイルに書く準備
		// バッファ付きで高速化
		// printlnなど便利な出力
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filePath, true)))) {

			while (true) {
				input = scanner.nextLine();
				if (input.equals("end")) {
					break;
				}
				// ファイルに書き込む
				pw.println(input);
			}
			System.out.println("書き込みが完了しました。");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}

	}

}

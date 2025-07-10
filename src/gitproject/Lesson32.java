package gitproject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * 指定したファイルを削除する
 */
public class Lesson32 {

	public static void main(String[] args) {
		System.out.println("削除したいファイルのパスを入力してください。");
		Scanner scanner = new Scanner(System.in);

		String filePath = scanner.nextLine();

		Path p = Paths.get(filePath);
		if (Files.exists(p)) {
			try {
				Files.delete(p);
				System.out.println("ファイルを削除しました。: " + filePath);
			} catch (IOException e) {
				System.out.println("削除に失敗しました。: " + e.getMessage());
				System.out.println(e);
			}
		} else {
			System.out.println("指定されたファイルは存在しません。: " + filePath);
		}
		scanner.close();
	}

}

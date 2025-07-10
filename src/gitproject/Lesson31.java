package gitproject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * 指定したパスにフォルダを作成する
 */
public class Lesson31 {

	public static void main(String[] args) {
		System.out.println("作成したいフォルダ名を入力してください。");
		Scanner scanner = new Scanner(System.in);

		String folederName = scanner.nextLine();
		System.out.println("作成するパスを入力してください。");
		String folederPath = scanner.nextLine();

		String fullPath = folederPath + "\\" + folederName;

		createFoleder(fullPath);
	}

	private static void createFoleder(String fullPath) {
		Path p = Paths.get(fullPath);
		try {
			Files.createDirectory(p);
			System.out.println("フォルダを作成しました。: " + fullPath);
		} catch (IOException e) {
			System.out.println("フォルダ作成に失敗しました。: " + e.getMessage());

		}

	}

}

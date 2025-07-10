package gitproject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * テキストファイルを一行ずつ読み込んで出力する
 */
public class Lesson34 {
	public static void main(String[] args) {
		System.out.println("読み込むファイルのパスを入力してください。");
		Scanner scanner = new Scanner(System.in);
		String filePath = scanner.nextLine();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				// 読み込んだ行を処理
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

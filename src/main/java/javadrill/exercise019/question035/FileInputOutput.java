package javadrill.exercise019.question035;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.transaction.annotation.Transactional;

/**
 * ファイルの読み書きをするプログラム
 */
public class FileInputOutput {
	@Transactional
	public static void main(String[] args) {
		String filePath = "C:\\Users\\highe\\Documents\\gitproject\\dog.txt";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
			bw.write("ポメラニアン");
			

		} catch (FileNotFoundException e) {
			System.out.println("ファイルが見つかりませんでした。");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("ファイルの読み込みに失敗しました。");
			e.printStackTrace();
		}

	}

}

package javadrill.exercise017.question022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ImplementFileOperation implements FileOperation {

	@Override
	public String readFile(String inputFilePath) {
		try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
			String line;
			// データをコピーする
			while ((line = br.readLine()) != null) {
				return line;
			}

		} catch (FileNotFoundException e) {
			System.out.println("ファイルが見つかりませんでした。");

		} catch (IOException e) {
			System.out.println("ファイル読み込み中にエラーが起きました。");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void writeFile(String outputFilePath, String line) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
			bw.write(line);
		} catch (IOException e) {
			System.out.println("ファイル書き込み中にエラーが起きました。");
			e.printStackTrace();
		}

	}

}

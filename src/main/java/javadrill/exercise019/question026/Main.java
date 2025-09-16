package javadrill.exercise019.question026;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws CustomFileReadException {

		System.out.println("読み取るファイルのパスを入力してください。");
		Scanner sc = new Scanner(System.in);
		String filePath = sc.nextLine();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
		
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (FileNotFoundException e) {
			System.out.println("ファイルが見つかりませんでした。");
		}catch (IOException e) {
			System.out.println("何かしらのエラーが発生しました。");
			e.printStackTrace();
		}

	}

}

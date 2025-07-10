import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * プロパティファイル内の設定値を出力する
 */
public class Lesson36 {

	public static void main(String[] args) {
		String propertiesFilePath = "C:\\pleiades\\2023-12\\workspace\\SelfStudy\\src\\example.properties";
		File propertiesFile = new File(propertiesFilePath);
		if (propertiesFile.exists()) {
			try (BufferedReader br = new BufferedReader(new FileReader(propertiesFilePath))) {
				String line;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("ファイルが見つかりませんでした。");
		}

	}
}
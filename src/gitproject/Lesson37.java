import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * 指定したフォルダ直下の全ファイルを別フォルダにコピーする
 */
public class Lesson37_2 {

	public static void main(String[] args) {
		copyFile("C:\\Users\\highe\\OneDrive\\ドキュメント\\課題", "C:\\Users\\highe\\OneDrive\\ドキュメント\\課題2");
	}
	/**
	 * 指定されたフォルダに全ファイルをコピーするメソッド
	 * @param source
	 * @param destination
	 */
	private static void copyFile(String source, String destination) {
		File sourceFile = new File(source);
		// listFiles()メソッドでファイルとディレクトリのリストを取得
		File[] files = sourceFile.listFiles();
		try {
			// 取得したリストを処理
			if (files != null) {
				for (File file : files) {
					if (file.isFile()) {
						Path sourceFilePath = file.toPath();
						Path destinationFilePath = Paths.get(destination, file.getName());
						// ファイルをコピー
						Files.copy(sourceFilePath, destinationFilePath, StandardCopyOption.REPLACE_EXISTING);
					}	
				}
				System.out.println("全ファイルコピーしました。");
			} else {
				System.out.println("指定されたパスにファイルまたはディレクトリが存在しません。");
			}
		} catch (IOException e) {
			System.err.println("ファイルのコピー中にエラーが発生しました。: " + e.getMessage());
		}
	}

}

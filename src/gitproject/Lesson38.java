package gitproject;
import java.io.File;

/**
 * 指定したフォルダ配下に存在する全てのフォルダの一覧を出力する
 */
public class Lesson38 {

	public static void main(String[] args) {
		String folderPath = "C:\\Users\\highe\\OneDrive\\ドキュメント";
		getAllFolderName(folderPath);
	}
	private static void getAllFolderName(String folder) {
		// Fileオブジェクトを作成
		File folderFile = new File(folder);
		// listFiles()メソッドでファイル一覧を取得
		File[] files = folderFile.listFiles();
		if (files != null) {
			for (File file : files) {
				if (file.isFile()) {
					System.out.println("ファイル: " + file.getName());
				} else if (file.isDirectory()) {
					System.out.println("ディレクトリ: " + file.getName());
				}
			}
		} else {
			System.out.println("指定されたフォルダにファイルはありません。");
		}
	}

}

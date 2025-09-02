package javadrill.exercise017.question022;

public interface FileOperation {
	/**
	 * ファイルからデータを読み込むメソッド
	 * @param inputFileName
	 * @return
	 */
	String readFile(String inputFileName);

	/**
	 * ファイルにデータを書き込むメソッド
	 */
	void writeFile(String inputFileName, String fact);

}

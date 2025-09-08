package javadrill.exercise013.question002;

public class Question002 {

	public static void main(String[] args) {

		System.out.println(chainString("hello", "world"));
		String[] stringArray = spliteString("apple,orange,banana");
		for (String string : stringArray) {
			System.out.println(string);
		}
	}

	/**
	 * 2つの文字列を結合する
	 * @param str1
	 * @param str2
	 */
	private static String chainString(String str1, String str2) {
		StringBuilder sb = new StringBuilder();
		sb.append(str1);
		sb.append(str2);
		return sb.toString();
	}

	/**
	 * カンマで区切られた文字列を取り込み、それを分割して配列に格納する
	 * @param str
	 */
	private static String[] spliteString(String str) {
		// カンマで分割して配列に格納
		String[] stringArray = str.split(",");
		return stringArray;
	}
}

package javadrill.exercise008.question011;

public class Question011 {
	/**
	 * 与えられた文字列を逆順に
	 * @return
	 */
	public static String reverseString(String str) {
		char[] strCharArray = str.toCharArray();
		char[] reversedStrCharArray = new char[strCharArray.length];
		for (int i = 0; i < strCharArray.length; i++) {
			reversedStrCharArray[i] = strCharArray[strCharArray.length - i - 1];
		}
		str = new String(reversedStrCharArray);
		return str;

	}

	/**
	 * 与えられた文字列を大文字に変換
	 * @return
	 */
	public static String toUpperCase(String str) {
		return str = str.toUpperCase();

	}

	/**
	 * 文字列を逆順にし、その後に toUpperCase メソッドを使って大文字に変換
	 * @return
	 */
	public static String reverseAndUpperCase(String str) {
		String reversedString = reverseString(str);
		String toUpperCasedString = toUpperCase(reversedString);
		return toUpperCasedString;

	}
}

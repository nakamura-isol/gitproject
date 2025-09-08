package javadrill.exercise008.question017;

public class Question017 {

	public static void main(String[] args) {
		String reversedString = reverseString("あいうえお");
		System.out.println(reversedString);
	}

	/**
	 * 文字列を引数として受け取り、その文字列を逆順に変更する
	 * @param str
	 * @return
	 */
	public static String reverseString(String str) {
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		str = sb.toString();
		return str;
	}
}

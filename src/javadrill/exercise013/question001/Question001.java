package javadrill.exercise013.question001;

public class Question001 {

	public static void main(String[] args) {
		String reversedString =reverseString("なかむらえりか");
		System.out.println(reversedString);

	}

	/**
	 * 与えられた文字列を逆順にする
	 * @return
	 */
	private static String reverseString(String str) {
		char[] charString = str.toCharArray();
		StringBuilder sb = new StringBuilder();

		for (int i = charString.length - 1; i >= 0; i--) {
			sb.append(charString[i]);
		}
		String reversedString = sb.toString();

		return reversedString;
	}

}

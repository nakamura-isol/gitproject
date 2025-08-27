package javadrill.exercise008.question020;

public class Question020 {

	public static void main(String[] args) {
		String concatenatedStrings = concatenateStrings("中村", "恵梨香");
		System.out.println(concatenatedStrings);
	}

	public static String concatenateStrings(String str1, String str2) {

		StringBuilder sb = new StringBuilder();
		sb.append(str1);
		sb.append(str2);
		String concatenatedStrings = sb.toString();

		return concatenatedStrings;
	}

}

package javadrill.exercise008.question014;

public class Question014 {

	public static void main(String[] args) {
		String grade = calculateGrade(60);
		System.out.println(grade);

	}

	public static String calculateGrade(int score) {
		String result = null;
		if (score >= 90) {
			result = "A";
			return result;
		} else if (score >= 80) {
			result = "B";
		} else if (score >= 70) {
			result = "C";
		} else if (score >= 60) {
			result = "D";
		} else if (score < 60) {
			result = "F";
		}
		return result;
	}

}

package javadrill.exercise005;

import java.util.Scanner;

public class Question025 {

	public static void main(String[] args) {
		boolean isFemale = false;
		boolean isOverTwenty = false;
		System.out.println("女性か男性かお答えください。");
		Scanner sc = new Scanner(System.in);
		String answerOfSex = sc.nextLine();
		if (answerOfSex.equals("女性")) {
			isFemale = true;
		}
		System.out.println("20歳以上かどうかを、はいかいいえでお答えください。");
		String answerOfAge = sc.nextLine();
		if (answerOfAge.equals("はい")) {
			isOverTwenty = true;
		}

		if (isFemale && isOverTwenty) {
			System.out.println("成人女性です。");
		} else {
			System.out.println("条件に該当しません");
		}

	}

}

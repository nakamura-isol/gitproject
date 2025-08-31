package javadrill.exercise004.question028;

import java.util.Random;

public class Question028 {

	public static void main(String[] args) {
		int[] originalArray = new int[10];
		
		Random random = new Random();
		for (int i = 0; i < originalArray.length; i++) {
			originalArray[i] = random.nextInt(100);
		}

		int[] copiedArray = new int[originalArray.length];

		for (int i = 0; i < originalArray.length; i++) {
			copiedArray[i] = originalArray[i];
		}

		for (int i = 0; i < copiedArray.length; i++) {
			System.out.print(copiedArray[i]);
			if (i < copiedArray.length - 1) {
				System.out.print(",");
			}
		}
	}

}

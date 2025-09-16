package javadrill.exercise006;

public class Question005 {

	public static void main(String[] args) {
		int[] numArray = new int[10];
		for (int i = 0; i < numArray.length; i++) {
			numArray[i] = i + 1;

		}
		for (int i = 0; i < numArray.length; i++) {
			if (numArray[i] % 2 == 0) {
				System.out.println(numArray[i] * 3);
			} else {
				System.out.println(numArray[i]);
			}
		}

	}
}

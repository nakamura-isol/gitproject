package javadrill.exercise004.question023;

public class Question023 {

	public static void main(String[] args) {
		int[] array = new int[3];
		array[0] = 1;
		array[1] = 2;
		array[2] = 3;

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i < array.length - 1) {
				System.out.print(",");
			}
		}
	}

}

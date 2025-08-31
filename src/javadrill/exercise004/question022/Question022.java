package javadrill.exercise004.question022;

public class Question022 {

	public static void main(String[] args) {
		int[] array = new int[7];
		array[0] = 1;
		array[1] = 2;
		array[2] = 3;
		array[3] = 4;
		array[4] = 5;
		array[5] = 6;
		array[6] = 7;

		for (int i = 0; i < array.length; i++) {
			array[i] = array[i] * 2;
		}

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i < array.length - 1) {
				System.out.print(",");
			}
		}
	}

}

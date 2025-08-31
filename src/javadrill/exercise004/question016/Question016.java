package javadrill.exercise004.question016;

public class Question016 {

	public static void main(String[] args) {
		int[] numArray = { 2, 9, 67, 34, 66, 12 };
		// 奇数
		int[] oddArray = new int[numArray.length];
		// 偶数
		int[] evenArray = new int[numArray.length];

		int oddCount = 0;
		int evenCount = 0;

		for (int i = 0; i < numArray.length; i++) {
			if (numArray[i] % 2 != 0) {
				oddArray[oddCount] = numArray[i];
				oddCount++;
			} else {
				evenArray[evenCount] = numArray[i];
				evenCount++;
			}
		}
		for (int i = 0; i < oddCount; i++) {
			// 最後のインデックスには,付けない
			System.out.print(oddArray[i]);
			if (i < oddCount - 1) {
				System.out.print(",");
			}
		}
		System.out.println();

		for (int i = 0; i < evenCount; i++) {
			System.out.print(evenArray[i]);
			if (i < evenCount - 1) {
				System.out.print(",");
			}
		}
	}

}

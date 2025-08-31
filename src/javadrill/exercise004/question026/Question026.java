package javadrill.exercise004.question026;

public class Question026 {

	public static void main(String[] args) {
		int[] sourceArray = new int[5];
		// 1~5の数字を入れる
		for (int i = 0; i < sourceArray.length; i++) {
			sourceArray[i] = i + 1;
		}
		int[] targetArray = new int[5];
		for (int i = 0; i < sourceArray.length; i++) {
			targetArray[i] = sourceArray[i];
		}
		for(int i = 0; i <targetArray.length;i++) {
			System.out.print(targetArray[i]);
			if (i < targetArray.length - 1) {
				System.out.print(",");
			}
		}
	}

}

package javadrill.exercise004.question039;

public class Question039 {

	public static void main(String[] args) {
		int[][][] cube = {
				{ { 1, 2 }, { 3, 4 } },
				{ { 5, 6 }, { 7, 8 } },
				{ { 9, 10 }, { 11, 12 } }
				
		};
		
		int value = cube[2][1][0];
		// 取得した値を表示
		System.out.println("cube[2][1][0] の値は: " + value);

	}

}

package javadrill.exercise004.question021;

import java.util.Random;

public class Question021 {

	public static void main(String[] args) {
		double[] doubleRandomArray1 = createDoubleRandomArray(10);
		for (double randomArray : doubleRandomArray1) {
			System.out.println(randomArray);
		}
		System.out.println();
		
		double[] doubleRandomArray2 = extraCreateDoubleRandomArray(10);
		for (double randomArray : doubleRandomArray2) {
			System.out.println(randomArray);
		}
	}

	private static double[] createDoubleRandomArray(int arrayLength) {
		double[] doubleRandomArray = new double[arrayLength];
		double min = 0.0;
		double max = 9.0;
		double range = max - min;
		// min以上 max未満のdouble型乱数
		for (int i = 0; i < doubleRandomArray.length; i++) {
			double doubleRandomNum = min + Math.random() * range;
			doubleRandomArray[i] = doubleRandomNum;
		}

		return doubleRandomArray;

	}
	
	private static double[] extraCreateDoubleRandomArray(int arrayLength) {
		double[] doubleRandomArray = new double[arrayLength];
		
		 // 乱数生成器を作成
        Random random = new Random();
        // 0から9までのランダムな浮動小数点数を代入
		
		// min以上 max未満のdouble型乱数
		for (int i = 0; i < doubleRandomArray.length; i++) {
			// 0から9の範囲の乱数
			double doubleRandomNum = random.nextDouble()* 10.0;
			doubleRandomArray[i] = doubleRandomNum;
		}

		return doubleRandomArray;

	}
}

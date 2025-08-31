package javadrill.exercise004.question013;

public class Question014 {

	public static void main(String[] args) {
		int[] numArray = { 2, 9, 67, 34, 66, 12 };
		int maxNum = numArray[0];
		int minNum = numArray[0];
		
	       // 最大値と最小値を初期化
//        int max = Integer.MIN_VALUE; // 最小の整数で初期化
//        int min = Integer.MAX_VALUE; // 最大の整数で初期化

		
		for(int i=0;i<numArray.length;i++) {
			if(numArray[i]>maxNum) {
				maxNum = numArray[i];
			}
			
			if(numArray[i]<minNum) {
				minNum = numArray[i];
			}
		}
		System.out.println(maxNum+","+minNum);
	}

}

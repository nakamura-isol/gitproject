package javadrill.exercise004;

public class Question015 {

	public static void main(String[] args) {
		int[] numArray = { 2, 9, 67, 34, 66, 12 };
		int targetNum =12;
		 // インデックスを格納する変数を初期化
		int indexOfTargetNum =-1;
		for(int i =0;i<numArray.length;i++) {
			if(targetNum==numArray[i]) {
				indexOfTargetNum = i;
				break;
			}
		}
		System.out.println(indexOfTargetNum);
		
	}

}

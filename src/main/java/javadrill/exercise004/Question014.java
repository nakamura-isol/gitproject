package javadrill.exercise004;

public class Question014 {

	public static void main(String[] args) {
		int[] numArray = { 2, 9, 67, 34, 66, 12 };
		int maxNum = numArray[0];
		int minNum = numArray[0];
		
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

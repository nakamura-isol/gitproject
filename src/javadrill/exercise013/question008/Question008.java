package javadrill.exercise013.question008;

public class Question008 {

	public static void main(String[] args) {
		int num = 12;
		
		double doubleNum = Double.valueOf(num);
		System.out.println(doubleNum);
		
		
		int intNum = Double.valueOf(doubleNum).intValue();
		System.out.println(intNum);
		
		

	}

}

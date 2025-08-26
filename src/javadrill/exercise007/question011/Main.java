package javadrill.exercise007.question011;

public class Main {

	public static void main(String[] args) {

		Calculator calculator = new Calculator(3, 1);

		int additionResult = calculator.addition();
		int subtractionResult = calculator.subtraction();
		System.out.println("足し算の結果：" + additionResult);
		System.out.println("引き算の結果：" + subtractionResult);

	}

}

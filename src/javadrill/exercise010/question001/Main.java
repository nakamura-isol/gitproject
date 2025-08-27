package javadrill.exercise010.question001;

public class Main {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		int intResult = calculator.add(1, 1);
		double doubleResult = calculator.add(1.1, 1.1);
		String stringResult = calculator.add("中村", "恵梨香");
		System.out.println("int型の連結：" + intResult);
		System.out.println("double型の連結：" + doubleResult);
		System.out.println("String型の連結：" + stringResult);
	}

}

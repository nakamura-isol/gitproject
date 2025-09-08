package javadrill.exercise008.question005;

public class Main {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		double result  = calculator.add(10.5, 5.2);
		System.out.println("加算の結果: " + result);
		result  =calculator.subtract(10.5, 5.2);		
		System.out.println("減算の結果: " + result);

		result  =calculator.multiply(10.5, 5.2);
		System.out.println("乗算の結果: " + result);

		result  =calculator.divide(10.5, 5.2);
		System.out.println("除算の結果: " + result);

	}

}

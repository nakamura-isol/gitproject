package javadrill.exercise008.question005;

public class Calculator {
	// 加算メソッド
	public double add(double num1, double num2) {
		double result = num1 + num2;
		return result;

	}

	// 減算メソッド
	public double subtract(double num1, double num2) {
		double result = num1 - num2;
		return result;

	}

	// 乗算メソッド
	public double multiply(double num1, double num2) {
		double result = num1 * num2;
		return result;

	}

	public double divide(double num1, double num2) {
		if (num2 != 0) {
			double result = num1 / num2;
			return result;
		}

		else {
			System.out.println("除数が0です。");
			// NaN (Not a Number) を返すことでエラー状態を示す
			return Double.NaN;
		}

	}

}

package javadrill.exercise007.question011;

public class Calculator {
	private int x;
	private int y;

	Calculator(int x, int y) {
		this.x = x;
		this.y = y;

	}

	public int addition() {
		int additionResult = x + y;
		return additionResult;
	}

	public int subtraction() {
		int subtractionResult = x - y;
		return subtractionResult;
	}
}

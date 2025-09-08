package javadrill.exercise012.question002;

public class Countdown {
	/**
	 * staticなカウントダウン変数
	 */
	private static int initialValue = 0;
	/**
	 * 現在のカウントダウン変数
	 */
	private int currentValue;

	Countdown() {
		// カウントダウンの初期値を代入し、現在の値を初期化
		currentValue = initialValue;
	}

	void performCountdown() {
		if (currentValue > 0) {
			currentValue--;
			System.out.println("Countdown: " + currentValue);
		} else {
			System.out.println("Countdown reached zero.");
		}
	}

	static void setInitialValue(int value) {
		initialValue = value;
	}

	static int getInitialValue() {
		return initialValue;
	}

}

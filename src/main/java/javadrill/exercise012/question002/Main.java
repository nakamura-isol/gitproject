package javadrill.exercise012.question002;

public class Main {

	public static void main(String[] args) {
		Countdown.setInitialValue(5);
		Countdown counter1 = new Countdown();
		counter1.performCountdown();
		counter1.performCountdown();
		
		Countdown counter2 = new Countdown();
		counter2.performCountdown();
		
	}

}

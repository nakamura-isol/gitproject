package javadrill.exercise008.question012;

public class Main {

	public static void main(String[] args) {
		Counter counter = new Counter();

		counter.increaseCounter(2);
		counter.increaseCounter(2);
		counter.increaseCounter(2);
		counter.decreaseCounter(2);
		counter.decreaseCounter(2);
		counter.decreaseCounter(2);


		counter.displayCounter();

	}

}

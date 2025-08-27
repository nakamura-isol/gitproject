package javadrill.exercise008.question012;

public class Counter {
	int counter;

	Counter() {
		this.counter = 0;
	}

	public int increaseCounter(int count) {

		return counter += count;
	}

	public int decreaseCounter(int count) {
		return counter -= count;
	}

	public void displayCounter() {
		System.out.println(counter);

	}

}

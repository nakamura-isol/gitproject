package javadrill.exercise012.question001;

public class Main {

	public static void main(String[] args) {
		SimpleCounter simpleCounter1 = new SimpleCounter();
		simpleCounter1.incrementInstanceCount();

		SimpleCounter simpleCounter2 = new SimpleCounter();
		simpleCounter2.incrementInstanceCount();
		simpleCounter2.incrementInstanceCount();

		System.out.println("Total Count: " + SimpleCounter.getTotalCount());
		System.out.println("simpleCounter1 Instance Count: " + simpleCounter1.getInstanceCount());
		System.out.println("simpleCounter2 Instance Count: " + simpleCounter2.getInstanceCount());
	}
}

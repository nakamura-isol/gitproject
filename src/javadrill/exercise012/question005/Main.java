package javadrill.exercise012.question005;

public class Main {

	public static void main(String[] args) {
		InstanceCounter instanceCounter1 = new InstanceCounter();
		System.out.println(instanceCounter1.getInstanceCount());
		InstanceCounter instanceCounter2 = new InstanceCounter();
		System.out.println(instanceCounter2.getInstanceCount());
		System.out.println(InstanceCounter.getInstanceCount());


	}

}

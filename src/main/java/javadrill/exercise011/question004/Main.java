package javadrill.exercise011.question004;

public class Main {

	public static void main(String[] args) {
		Car car1 = new Car();
		System.out.println(car1.getBrand() + "\t" + car1.getModel());
		Car car2 = new Car("ベンツ", "BMW");

		System.out.println(car2.getBrand() + "\t" + car2.getModel());

	}

}

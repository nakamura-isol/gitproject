package javadrill.exercise007.question016;

public class Main {

	public static void main(String[] args) {

		Car car = new Car("ベンツ", "BMW", 180);
		Owner owner = new Owner("中村恵梨香", "08066667777");
		car.setOwner(owner);
		car.displayInfo();
	}

}

package javadrill.exercise014.question001;

public class VehicleTest {

	public static void main(String[] args) {
		Car car = new Car();
		Bicycle bicycle = new Bicycle();
		car.start();
		car.accelerate();
		car.stop();
		
		bicycle.start();
		bicycle.ringBell();
		bicycle.stop();
	}

}

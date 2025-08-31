package javadrill.exercise014.question011;

public class Vehicle {
	String color;

	Vehicle(String color) {
		this.color = color;
		System.out.println("Vehicleクラスのコンストラクタが呼ばれました。");
	}

	String getColor() {
		return color;
	}

	void setColor(String color) {
		this.color = color;
	}
}

package javadrill.exercise007.question016;

public class Car {
	private String model;
	private String color;
	private int speed;
	private Owner owner;

	Car(String model, String color, int speed) {
		this.model = model;
		this.color = color;
		this.speed = speed;
	}

	void accelerate(int speed) {
		this.speed = speed;
	}

	void setOwner(Owner owner) {
		this.owner = owner;
	}

	String getModel() {
		return model;
	}

	String getColor() {
		return color;
	}

	int getSpeed() {
		return speed;
	}

	Owner getOwner() {
		return owner;
	}

	void displayInfo() {
		System.out.println("Model: " + model);
		System.out.println("color: " + color);
		System.out.println("speed: " + speed);
		// 車の所有者が設定されている場合は所有者の情報を表示
		if (owner != null) {
			System.out.println("OwnerName: " + owner.getName());
			System.out.println("OwnerTel: " + owner.getPhoneNum());

		}
	}
}

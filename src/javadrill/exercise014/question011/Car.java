package javadrill.exercise014.question011;

public class Car extends Vehicle {
	int speed;

	Car(String color, int speed) {
		// スーパークラスのコンストラクタが明示的に呼び出される
		super(color);
		this.speed = speed;

	}

	int getSpeed() {
		return speed;
	}

	void setSpeed(int speed) {
		this.speed = speed;
	}

}

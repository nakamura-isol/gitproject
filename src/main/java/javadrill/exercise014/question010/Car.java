package javadrill.exercise014.question010;

public class Car extends Vehicle {
	private int speed ;
	
	Car(String color,int speed) {
		  // 親クラスのデフォルトコンストラクタが暗黙的に呼び出される
		this.color = color;
		this.speed = speed;
	}

	int getSpeed() {
		return speed;
	}

	void setSpeed(int speed) {
		this.speed = speed;
	}

	
}

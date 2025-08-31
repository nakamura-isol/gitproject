package javadrill.exercise014.question013;

public class Car extends Vehicle{
	int speed;
	Car(String color,int speed) {
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

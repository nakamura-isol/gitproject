package javadrill.exercise014.question014;

public class Rectangle extends Shape {

	int width;
	int high;

	Rectangle(String color, int width, int high) {
		super(color);
		this.width = width;
		this.high = high;

	}

	int getArea(int width, int high) {

		return width * high;

	}

	int getWidth() {
		return width;
	}

	void setWidth(int width) {
		this.width = width;
	}

	int getHigh() {
		return high;
	}

	void setHigh(int high) {
		this.high = high;
	}
}

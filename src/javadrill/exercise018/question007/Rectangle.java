package javadrill.exercise018.question007;

public class Rectangle extends Shape {

	double high;
	double width;

	Rectangle(double high, double width) {
		this.high = high;
		this.width = width;
	}

	@Override
	double calculateArea() {
		
		return 2 * (high + width);
	}

}

package javadrill.exercise018.question001;

/**
 * 長方形クラス
 */
public class Rectangle extends Shape {

	double high;
	double width;

	Rectangle(double high, double width) {
		this.high = high;
		this.width = width;
	}

	@Override
	double getArea() {

		return high * width;
	}

	@Override
	double getPerimeter() {

		return high * 2 + width * 2;
	}

}

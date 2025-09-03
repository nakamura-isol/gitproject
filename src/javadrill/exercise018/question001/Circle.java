package javadrill.exercise018.question001;

/**
 * 円クラス
 */
public class Circle extends Shape {
	double radius;

	Circle(double radius) {
		this.radius = radius;
	}

	@Override
	double getArea() {

		return radius * radius * 3.14;
	}

	@Override
	double getPerimeter() {

		return radius * 2 * 3.14;
	}

}

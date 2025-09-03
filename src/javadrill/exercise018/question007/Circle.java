package javadrill.exercise018.question007;

public class Circle extends Shape {

	double radius;

	Circle(double radius) {
		this.radius = radius;
	}

	@Override
	double calculateArea() {

		return radius*radius*3.14;
	}

}

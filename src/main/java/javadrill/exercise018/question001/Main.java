package javadrill.exercise018.question001;

public class Main {

	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(3.5, 5.5);
		System.out.println(rectangle.getArea());
		System.out.println(rectangle.getPerimeter());

		Circle circle = new Circle(5);
		System.out.println(circle.getArea());
		System.out.println(circle.getPerimeter());

		Triangle triangle = new Triangle(3, 6, 6);
		System.out.println(triangle.getArea());
		System.out.println(triangle.getPerimeter());

	}

}

package javadrill.exercise009.question005;

public class Main {

	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle();
		double area = rectangle.calculateArea(5.0, 3.0);
		double perimeter = rectangle.calculatePerimeter(5.0, 3.0);
		System.out.println(area+"\t"+perimeter);

	}

}

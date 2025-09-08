package javadrill.exercise015.question010;

public class Main {

	public static void main(String[] args) {
		Shape[] variousShapeArray = new Shape[3];
		variousShapeArray[0] = new Shape();
		variousShapeArray[1] = new Square();
		variousShapeArray[2] = new Circle();

		for (Shape shape : variousShapeArray) {
			if (shape instanceof Circle) {
				Circle circleShape = (Circle) shape;
				circleShape.draw();
				circleShape.calculateArea();
			} else if (shape instanceof Square) {
				Square squareShape = (Square) shape;
				squareShape.draw();
				squareShape.calculateArea();
			}
		}

	}

}

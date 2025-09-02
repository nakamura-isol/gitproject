package javadrill.exercise015.question006;

public class Main {

	public static void main(String[] args) {
		Shape shape = new Shape();
		shape.draw();
		Circle circle = new Circle();
		circle.draw();
		
		Shape upcastCircle = new Circle();
		upcastCircle.draw();
	}

}

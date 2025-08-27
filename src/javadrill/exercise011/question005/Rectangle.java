package javadrill.exercise011.question005;

public class Rectangle {
	private double length;
	private double width;

	// デフォルトコンストラクタ
	public Rectangle() {
		this.length = 1.0;
		this.width = 1.0;
	}

	// 引数を受け取るコンストラクタ
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}
}

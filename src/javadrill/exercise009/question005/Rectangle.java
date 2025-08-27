package javadrill.exercise009.question005;

public class Rectangle {
	/**
	 * 長方形の面積を計算するメソッド
	 * @return
	 */
	public static double calculateArea(double length, double width) {
		double area = length * width;
		return area;
	}

	/**
	 * 長方形の周囲の長さを計算するメソッド
	 * @return
	 */
	public static double calculatePerimeter(double length, double width) {
		double perimeter = (length + width) * 2;
		return perimeter;
	}

}

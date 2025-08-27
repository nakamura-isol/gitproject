package javadrill.exercise008.question013;

public class Question013 {

	public static void main(String[] args) {
		double area = calculateTriangleArea(5.0, 10.0);
		System.out.println(area);
	}

	/**
	 * 三角形の底辺（base）と高さ（height）を引数として受け取り、三角形の面積を計算して返す
	 * @return
	 */
	public static double calculateTriangleArea(double base, double height) {
		double area = base * height / 2;
		return area;
	}
}

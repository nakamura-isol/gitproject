package javadrill.exercise016.question006;

/**
 * 長方形の面積を計算する具象クラス
 */
public class Rectangle extends Shape {
	double high = 5.0;
	double bottom = 6.0;

	@Override
	double calculateArea() {

		return high * bottom;
	}

}

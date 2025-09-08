package javadrill.exercise016.question006;

/**
 * 円の面積を計算する具象クラス
 */
public class Circle extends Shape {
	double pie = 3.14;
	double radius = 3.0;

	@Override
	double calculateArea() {

		return radius * radius * pie;
	}

}

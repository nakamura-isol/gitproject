package javadrill.exercise018.question001;

/**
 * 三角形クラス
 */
public class Triangle extends Shape {
	double bottomLength;
	double rightLength;
	double leftLength;

	Triangle(double bottomLength, double rightLength, double leftLength) {
		this.bottomLength = bottomLength;
		this.rightLength = rightLength;
		this.leftLength = leftLength;

	}

	@Override
	double getArea() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	double getPerimeter() {
		return bottomLength+rightLength+leftLength;
	}

}

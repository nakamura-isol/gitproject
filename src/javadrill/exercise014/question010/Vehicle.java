package javadrill.exercise014.question010;

public class Vehicle {
	String color;



	// 車両クラスのデフォルトコンストラクタ
	Vehicle() {
		System.out.println("親クラスのデフォルトコンストラクタが呼び出されました。");
	}

	String getColor() {
		return color;
	}

	void setColor(String color) {
		this.color = color;
	}
}

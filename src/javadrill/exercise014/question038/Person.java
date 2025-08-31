package javadrill.exercise014.question038;

import java.util.Objects;

public class Person extends Object {

	private String name;
	private int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	/**
	 * Personオブジェクト同士が同じ名前と年齢を持つ場合にtrueを返す
	 */
	public boolean equals(Object obj) {
		// 引数がnullでないことを確認
		if (obj == null) {
			return false;

		}
		// 自分自身と比較している場合はtrueを返す
		// thisは今実行している Person クラスのインスタンス
		if (this == obj) {
			return true;
		}

		// クラスが異なる場合はfalseを返す
		if (getClass() != obj.getClass()) {
			return false;
		}
		// 引数をPersonクラスにキャスト
		Person other = (Person) obj;

		// Objectsクラスのequalsメソッドを使用してフィールドが等しいかどうかを確認

		return Objects.equals(this.name, other.name) && this.age == other.age;

	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	int getAge() {
		return age;
	}

	void setAge(int age) {
		this.age = age;
	}

}

package javadrill.exercise009.question001;

public class Person {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		// もし新しい名前がnullでなく、空でない場合にのみ設定
		if (!(name == null && name.isEmpty())) {
			this.name = name;
		} else {
			System.out.println("名前は null または空です。");
		}

	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		// もし新しい年齢が0以上の場合にのみ設定
		if (age >= 0) {
			this.age = age;
		} else {
			System.out.println("年齢は0以上である必要があります。");
		}

	}
}

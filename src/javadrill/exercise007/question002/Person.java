package javadrill.exercise007.question002;

public class Person {
	private String name;
	private int age;
	private String sex;

	Person(String name, int age, String sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String isSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void displayInfo() {
		System.out.println("Name: " + name + "\n" + "Age: " + age + "\n" + "Sex: " + sex);
	}
}

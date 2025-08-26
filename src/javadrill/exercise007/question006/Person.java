package javadrill.exercise007.question006;

public class Person {

	private String name;
	private int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
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

	public static void main(String[] args) {

		displayInfo(new Person("恵梨香", 30));

	}

	public static void displayInfo(Person person) {
		System.out.println(person.name + "\n" + person.age);
	}

}

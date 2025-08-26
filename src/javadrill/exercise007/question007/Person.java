package javadrill.exercise007.question007;

import java.util.ArrayList;
import java.util.List;

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
		List<Person> personList = new ArrayList<>();
		personList.add(new Person("恵梨香", 30));
		personList.add(new Person("美咲", 29));

		// 出力
		for (Person person : personList) {
			displayInfo(person);
		}

	}

	public static void displayInfo(Person person) {
		System.out.println(person.name + "\t" + person.age);
	}

}

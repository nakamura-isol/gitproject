package javadrill.exercise008.question016;

public class Main {

	public static void main(String[] args) {
		Person person = new Person();
		System.out.println("初期の名前：" + person.getName());
		person.changeName("恵梨香");
		System.out.println("変更後の名前：" + person.getName());
	}

}

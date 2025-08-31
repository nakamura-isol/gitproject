package javadrill.exercise014.question038;

public class Main {

	public static void main(String[] args) {
		Person person1 = new Person("恵梨香",30);
		Person person2 = new Person("恵梨香",30);
		Person person3 = new Person("花子",30);
		Person person4 = person1;
		
	    // equalsの結果を確認
        System.out.println("person1.equals(person2): " + person1.equals(person2)); // true（内容が同じ）
        System.out.println("person1.equals(person3): " + person1.equals(person3)); // false（内容が違う）
        System.out.println("person1.equals(person4): " + person1.equals(person4)); // true（同じインスタンス）
        System.out.println("person1.equals(null): " + person1.equals(null)); // false（nullは必ずfalse）

	}

}

package javadrill.exercise015.question008;

public class Main {

	public static void main(String[] args) {
		Animal animal = new Animal();
		// animalがDogのインスタンスかチェック
		if (animal instanceof Dog) {
			// AnimalクラスのオブジェクトanimalをDogクラスにダウンキャスト
			Dog dog = (Dog) animal;
			dog.bark();
		} else {
			System.out.println(("Animal is not a Dog"));
		}

	}

}

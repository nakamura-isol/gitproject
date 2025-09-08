package javadrill.exercise015.question016;

/**
 * 動的な配列を使用して異なる動物のオブジェクトを格納し、それぞれのオブジェクトがどのクラスのインスタンスかを確認する
 */
public class Main {

	public static void main(String[] args) {
		Animal[] animalArray = new Animal[3];
		animalArray[0] = new Animal();
		animalArray[1] = new Dog();
		animalArray[2] = new Cat();

		for (Animal animal : animalArray) {

			if (animal instanceof Animal) {
				System.out.println("このインスタンスはアニマルです。");
			} else if (animal instanceof Dog) {
				System.out.println("このインスタンスは犬です。");
			} else if (animal instanceof Cat) {
				System.out.println("このインスタンスは猫です。");
			}
			animal.makeSound();

		}

	}

}

package javadrill.exercise016.question011;
/**
 * ポリモフィズムを使用して、Animal型の配列を作成し、異なる種類の動物のサウンドを出力する
 */
public class Main {

	public static void main(String[] args) {
		Animal[] animalArray = new Animal[2];
		animalArray[0] = new Dog();
		animalArray[1] = new Cat();

		for (Animal animal : animalArray) {
			animal.makeSound();
		}

	}

}

package javadrill.exercise015.question005;

public class Main {

	public static void main(String[] args) {
		Animal animal = new Animal();
		animal.makeSound();
		Dog dog = new Dog();
		dog.makeSound();
		
		// アップキャストでAnimalクラスの参照変数でDogクラスのオブジェクトを操作
		Animal upcastedDog = new Dog();
		// Animalクラスの参照変数でDogクラスのmakeSoundメソッドを呼び出す
		// オーバーライドされたバージョンが呼ばれる
		upcastedDog.makeSound();
	}

}

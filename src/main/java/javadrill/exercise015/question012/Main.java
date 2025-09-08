package javadrill.exercise015.question012;

public class Main {

	public static void main(String[] args) {
		Animal[] animalArray = new Animal[2];
		animalArray[0] = new Dog();
		animalArray[1] = new Cat();
		
		for(Animal animal:animalArray) {
			animal.makeSound();
		}
	}

}

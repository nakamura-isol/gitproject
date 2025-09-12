package javadrill.exercise020.question003;

import java.util.Arrays;
import java.util.List;

public class Question003 {

	public static void main(String[] args) {
		List<String> fruitList = Arrays.asList("Apple", "Banana", "Orange", "Grapes", "Kiwi", "Mango");
		int targetIndex = fruitList.indexOf("Orange");
		System.out.println(targetIndex);
		fruitList.set(targetIndex, "Peach");
		for (String fruit : fruitList) {
			System.out.println(fruit);
		}

	}
}

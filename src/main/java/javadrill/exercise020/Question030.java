package javadrill.exercise020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 整数型のリストnumbersの要素をランダムにシャッフルする。
 */
public class Question030 {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));

		Collections.shuffle(numbers);

		System.out.println("Shuffled List: " + numbers);

	}

}

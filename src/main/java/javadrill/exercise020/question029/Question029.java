package javadrill.exercise020.question029;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 以下のListを逆順にして結果を表示する。
 */
public class Question029 {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));

		Collections.reverse(numbers);

		System.out.println("Reversed List: " + numbers);
	}

}

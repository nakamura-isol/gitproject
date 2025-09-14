package javadrill.exercise020.question028;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 以下のListを昇順でソートし、結果を表示する。
 */
public class Question028 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(7, 3, 1, 9, 5, 2, 8, 4, 6);

		Collections.sort(numbers);
        // ソート後のリストを表示
        System.out.println(numbers);

	}

}

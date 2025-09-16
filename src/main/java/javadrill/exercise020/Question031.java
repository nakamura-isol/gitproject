package javadrill.exercise020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 以下のリストに対して、指定された要素の出現回数を求める。
 */
public class Question031 {

	public static void main(String[] args) {
		// 整数型のリストを作成
		List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 2, 1, 3, 4, 5, 1));

		// 出現回数を求める要素
		int elementToFind = 1;
		int frequency = Collections.frequency(numbers, elementToFind);

		// 結果を表示
		System.out.println("1の出現回数は: " + frequency);

	}

}

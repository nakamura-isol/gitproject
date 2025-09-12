package javadrill.exercise020.question013;

import java.util.HashSet;
import java.util.Set;

/**
 * 与えられた整数型セット setNumbers の要素の合計を計算
 */
public class Question013 {

	public static void main(String[] args) {

		Set<Integer> numberSet = new HashSet<>();
		numberSet.add(10);
		numberSet.add(20);
		numberSet.add(30);
		int sum = 0;
		for (Integer number : numberSet) {
			sum += number;
		}
		System.out.println(sum);
	}

}

package javadrill.exercise020;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * 与えられた整数型リストのイテレーターを使用して、要素の合計を計算して表示する
 */
public class Question008 {

	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(10, 20, 30, 40, 50);
		ListIterator<Integer> iterator = values.listIterator();
		int sum = 0;
		while (iterator.hasNext()) {
			sum += iterator.next();
		}
		System.out.println(sum);
	}

}

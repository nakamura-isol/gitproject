package javadrill.exercise020.question010;

import java.util.HashSet;
import java.util.Set;

/**
 * 整数型setAとsetBを結合して新しいセットを作成し、要素を昇順で表示する
 */
public class Question010 {
	public static void main(String[] args) {
		Set<Integer> setA = new HashSet<>();
		setA.add(6);
		setA.add(2);
		setA.add(3);
		Set<Integer> setB = new HashSet<>();
		setB.add(1);
		setB.add(5);
		setB.add(4);

		setA.addAll(setB);
		System.out.println(setA);

	}

}

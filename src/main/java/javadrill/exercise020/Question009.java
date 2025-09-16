package javadrill.exercise020;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 与えられた整数型のリストから重複した要素を削除し、セットに変換して新しいリストに格納する
 */
public class Question009 {

	public static void main(String[] args) {
		// 与えられた整数型のリスト
		List<Integer> integerList = new ArrayList<>();
		integerList.add(1);
		integerList.add(2);
		integerList.add(3);
		integerList.add(1);
		integerList.add(3);

		// 重複を削除してセットに変換
		Set<Integer> integerSet = new HashSet<>();
		for (Integer integer : integerList) {
			integerSet.add(integer);
		}

		// セットを新しいリストに変換
		List<Integer> resultList = new ArrayList<>(integerSet);
		System.out.println(resultList);

	}

}

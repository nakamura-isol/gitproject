package javadrill.exercise020;

import java.util.ArrayList;
import java.util.List;

/**
 * list2の要素をlist1に追加し、最終的な結果を表示する。
 */
public class Question032 {

	public static void main(String[] args) {
		  // 最初のリスト
        List<String> list1 = new ArrayList<>();
        list1.add("Apple");
        list1.add("Banana");
        list1.add("Cherry");

        // 二つ目のリスト
        List<String> list2 = List.of("Orange", "Grapes", "Kiwi");

        // Collections.addAllメソッドを使用してlist2の要素をlist1に追加してください
        list1.addAll(list2);

        // 結果を表示
        System.out.println("Combined List: " + list1);

	}

}

package javadrill.exercise020;

import java.util.HashMap;
import java.util.Map;

/**
 * 与えられた文字列型のキーと整数型の値からなるwordCountMap特定のキーを持つエントリを削除する。
 */
public class Question019 {

	public static void main(String[] args) {
		Map<String, Integer> wordCountMap = new HashMap<>();
		wordCountMap.put("1月", 1);
		wordCountMap.put("2月", 2);
		wordCountMap.put("3月", 3);

		wordCountMap.remove("3月");
		System.out.println(wordCountMap);
	}

}

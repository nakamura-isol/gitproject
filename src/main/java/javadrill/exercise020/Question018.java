package javadrill.exercise020;

import java.util.HashMap;
import java.util.Map;

/**
 * 文字列型のキーと整数型の値からなるマップoriginalMapのキーと値を反転させた新しいマップreversedMapを作成する。
 */
public class Question018 {

	public static void main(String[] args) {
		Map<String, Integer> originalMap = new HashMap<>();
		originalMap.put("1月", 1);
		originalMap.put("2月", 2);
		originalMap.put("3月", 3);

		Map<Integer, String> reversedMap = new HashMap<>();
		for (Map.Entry<String, Integer> originalEntry : originalMap.entrySet()) {
			String key = originalEntry.getKey();
			Integer Value = originalEntry.getValue();
			reversedMap.put(Value, key);
		}
		System.out.println("originalMap：" + originalMap);
		System.out.println("reversedMap：" + reversedMap);
	}

}

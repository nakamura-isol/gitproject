package javadrill.exercise020.question021;

import java.util.HashMap;
import java.util.Map;

/**
 * 文字列型のキーと整数型の値のstringIntMapの各キーと値を連結して新しい文字列を作成し、concatenatedMapを作る
 */
public class Question021 {

	public static void main(String[] args) {
		Map<String, Integer> stringIntMap = new HashMap<>();
		stringIntMap.put("恵梨香", 30);
		stringIntMap.put("由梨恵", 34);
		stringIntMap.put("麻梨恵", 37);

		Map<String, String> concatenatedMap = new HashMap<>();

		for (String key : stringIntMap.keySet()) {
			int value = stringIntMap.get(key);
		
		}

	}

}

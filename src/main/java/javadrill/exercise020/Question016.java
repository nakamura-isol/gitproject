package javadrill.exercise020;

import java.util.HashMap;
import java.util.Map;

/**
 * 与えられた整数型のキーと値からなるマップageMap内で特定の値を持つエントリを削除する。
 */
public class Question016 {

	public static void main(String[] args) {

		Map<String, Integer> ageMap = new HashMap<>();
		ageMap.put("恵梨香", 30);
		ageMap.put("由梨恵", 34);
		ageMap.put("要", 36);
		ageMap.put("優理", 30);
		ageMap.put("友基", 32);

//		// イテレータを使用してエントリを反復処理
//		Iterator<Map.Entry<String, Integer>> iterator = ageMap.entrySet().iterator();
//
//		while (iterator.hasNext()) {
//			Map.Entry<String, Integer> entry = iterator.next();
//			int value = entry.getValue();
//			if (value == 30) {
//				iterator.remove();
//			}
//		}
//		System.out.println(ageMap);

		// for (Map.Entry<String, Integer> entry : ageMap.entrySet()) {
		// String key = entry.getKey();
		// int value = entry.getValue();
		//
		// if (value == 30) {
		// ageMap.remove(key);
		// }
		// }

	}
}

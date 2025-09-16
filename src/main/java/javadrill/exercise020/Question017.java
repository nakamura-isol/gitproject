package javadrill.exercise020;

import java.util.HashMap;
import java.util.Map;

/**
 * mapAの各エントリに対して、mapBの対応するキーが存在する場合は値を合計して、存在しない場合はそのまま保持して新しいマップを作成する。
 */
public class Question017 {

	public static void main(String[] args) {
		Map<String, Integer> mapA = new HashMap<>();
		mapA.put("Apple", 3);
		mapA.put("Banana", 2);
		mapA.put("Orange", 5);

		Map<String, Integer> mapB = new HashMap<>();
		mapB.put("Apple", 7);
		mapB.put("Banana", 4);
		mapB.put("Grapes", 6);

//		Map<String, Integer> mapAB = new HashMap<>();
//
//		// mapAの各エントリに対して処理
//		for (Map.Entry<String, Integer> entryA : mapA.entrySet()) {
//			String keyA = entryA.getKey();
//			int valueA = entryA.getValue();
//
//			// mapAに対応するキーがmapBに存在する場合は値を合計
//			if (mapB.containsKey(keyA)) {
//				int valueB = mapB.get(keyA);
//				mapAB.put(keyA, valueA + valueB);
//			} else {
//				// mapAに対応するキーがmapBに存在しない場合はそのまま保持
//				mapAB.put(keyA, valueA);
//			}
//		}
//		System.out.println(mapAB);
	}

}

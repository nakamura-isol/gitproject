package javadrill.exercise020.question022;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 文字列型のキーと整数型の値からなるpriceMapから最大の値を持つエントリを見つける
 */
public class Question022 {

	public static void main(String[] args) {
		// 与えられた文字列型のキーと整数型の値からなるマップ priceMap
		Map<String, Integer> priceMap = new HashMap<>();
		priceMap.put("Apple", 120);
		priceMap.put("Banana", 80);
		priceMap.put("Orange", 150);
		priceMap.put("Grapes", 200);

		Entry<String, Integer> entry = findMaxEntry(priceMap);
		System.out.println(entry);

	}

	/**
	 * マップ内で最大の値を持つエントリを見つけるメソッド
	 * @param map
	 * @return
	 */
	private static Entry<String, Integer> findMaxEntry(Map<String, Integer> map) {

		if (map.isEmpty()) {
			// マップが空の場合はnullを返すか、エラー処理を行うなど適切な対応を行う
			return null;
		}

		Entry<String, Integer> maxEntry = null;

		// マップの各エントリに対して処理
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
				// 最大エントリがnullまたは現在のエントリの値が最大エントリの値より大きい場合
				maxEntry = entry;
			}
		}

		return maxEntry;

	}

}

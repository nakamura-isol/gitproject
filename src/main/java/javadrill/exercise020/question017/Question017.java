package javadrill.exercise020.question017;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 与えられた２つの整数型のキーと値からなるマップmapAとmapBがある。
 * mapAの各エントリに対して、mapBの対応するキーが存在する場合は値を合計して、存在しない場合はそのまま保持して新しいマップを作成する。
 */
public class Question017 {

	public static void main(String[] args) {
		Map<Integer, Integer> mapA = new HashMap<>();
		mapA.put(1, 10);
		mapA.put(2, 20);
		mapA.put(3, 300);

		Map<Integer, Integer> mapB = new HashMap<>();
		mapB.put(1, 100);
		mapB.put(4, 40);
		mapB.put(3, 30);

		Iterator<Map.Entry<Integer, Integer>> iterator = mapA.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, Integer> entry = iterator.next();
//			for(Integer key :)) {
//				
//			}
		}

	}

}

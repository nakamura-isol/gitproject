package javadrill.exercise020.question020;

import java.util.HashMap;
import java.util.Map;

/**
 * 与えられた整数型のキーと値からなるscoreMaの値の平均を計算する。
 */
public class Question020 {

	public static void main(String[] args) {
		Map<Integer, Integer> scoreMap = new HashMap<>();
		scoreMap.put(1, 89);
		scoreMap.put(2, 75);
		scoreMap.put(3, 100);
		int sum = 0;
		for (Integer key : scoreMap.keySet()) {
			Integer value = scoreMap.get(key);
			sum += value;
		}
		int averageScore = sum / scoreMap.size();
		System.out.println(averageScore);

	}

}

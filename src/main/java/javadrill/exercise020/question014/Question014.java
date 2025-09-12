package javadrill.exercise020.question014;

import java.util.HashMap;
/**
 * 与えられた整数型のキーと値からなるマップnumberMapの値の合計を計算
 */
public class Question014 {

	public static void main(String[] args) {
		var numberMap = new HashMap<Integer, Integer>();
		numberMap.put(0, 100);
		numberMap.put(1, 200);
		numberMap.put(2, 300);
		int sum = 0;
		for (Integer value : numberMap.values()) {
			sum += value;
		}
		System.out.println(sum);
	}

}

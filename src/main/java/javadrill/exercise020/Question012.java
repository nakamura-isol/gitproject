package javadrill.exercise020;

import java.util.Set;

/**
 * 与えられた文字列型セットsetPとsetQが等しいかどうかを判定する。
 */
public class Question012 {

	public static void main(String[] args) {
		Set<String> setP = Set.of("Apple", "Banana", "Orange", "Grapes");
		Set<String> setQ = Set.of("Apple", "Banana", "Orange");
		boolean isEqual = true;
		if (setP.size() != setQ.size()) {
			isEqual = false;
		} else {
			for (String element : setP) {
				if (setQ.contains(element)) {
					isEqual = true;
				} else {
					isEqual = false;
				}
			}
		}
		System.out.println(isEqual);
	}

}

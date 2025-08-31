
package javadrill.exercise004.question017;

import java.util.ArrayList;
import java.util.List;

/**
 * 重複要素を削除する
 */
public class Question017 {

	public static void main(String[] args) {
		int[] numArray1 = { 2, 2, 1, 2, 3, 4, 3 };
		int[] numArray2 = { 2, 2, 1, 2, 3, 4, 3 };

		int[] newNumArray = removeDuplicates(numArray1);
		for (int i = 0; i < newNumArray.length; i++) {
			System.out.print(newNumArray[i]);
			if (i < newNumArray.length - 1) {
				System.out.print(",");

			}
		}
		System.out.println();

		int[] newNumArray2 = extraRemoveDuplicates(numArray2);
		for (int i = 0; i < newNumArray2.length; i++) {
			System.out.print(newNumArray2[i]);
			if (i < newNumArray2.length - 1) {
				System.out.print(",");

			}
		}
	}

	/**
	 * 配列から重複を削除する
	 * @param numArray
	 * @return
	 */
	private static int[] removeDuplicates(int[] numArray) {

		// contains()を使いたいから配列をListに変換する
		// Integerの配列にする必要がある
		Integer[] integerNumArray = new Integer[numArray.length];
		for (int i = 0; i < numArray.length; i++) {
			// 自動的にオートボクシングされる
			integerNumArray[i] = numArray[i];
		}
		// 一意の数字を入れるリスト
		List<Integer> numArrayList = new ArrayList<>();
		for (int num : integerNumArray) {
			if (!numArrayList.contains(num)) {
				numArrayList.add(num);
			}
		}
		// 一意数字リストから入れ替える新しい配列を用意
		int[] newNumArray = new int[numArrayList.size()];

		for (int i = 0; i < numArrayList.size(); i++) {
			newNumArray[i] = numArrayList.get(i);
		}
		return newNumArray;
	}

	private static int[] extraRemoveDuplicates(int[] numArray) {
		int length = numArray.length;
		int uniqueCount = 0;
		// 配列内の重複を削除
		for (int i = 0; i < length; i++) {
			boolean isDuplicate = false;
			// 今見ているiより前に同じ値が出ていないか確認する
			for (int j = 0; j < i; j++) {
				if (numArray[i] == numArray[j]) {
					isDuplicate = true;
					break;
				}
			}
			// 重複でない（一意）ならカウントする
			if (!isDuplicate) {
				uniqueCount++;
			}
		}
		// 重複を削除した新しい配列を作成
		int[] uniqueArray = new int[uniqueCount];
		int currentIndex = 0;
		for (int i = 0; i < length; i++) {
			boolean isDuplicate = false;
			for (int j = 0; j < i; j++) {
				if (numArray[i] == numArray[j]) {
					isDuplicate = true;
					break;
				}
			}
			if (!isDuplicate) {
				uniqueArray[currentIndex] = numArray[i];
				currentIndex++;
			}
		}
		return uniqueArray;
	}
}

package javadrill.exercise012.question004;

public class StringUtils {
	/**
	 * 与えられた文字列が回文かどうかを判定するメソッド
	 * @param str
	 * @return
	 */
	static boolean isPalindrome(String str) {
		// 入力文字列から非アルファベット文字を削除し、
		str = str.replaceAll("[^a-zA-Z0-9]", "");
		// 小文字に変換
		str = str.toLowerCase();
		// 文字列を前後から比較して回文か判定
		int left = 0;
		int right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	/**
	 * 与えられた文字列を逆さまにするメソッド
	 * @param str
	 */
	static String reverseString(String str) {
		// 文字列を逆順にして新しい文字列を生成
		StringBuilder reversed = new StringBuilder();
		// 反対のインデックスで作る
		for (int i = str.length() - 1; i >= 0; i--) {
			char charStr = str.charAt(i);
			reversed = reversed.append(charStr);
		}
		return reversed.toString();
	}

	/**
	 * 与えられた文字列内で指定された文字が出現する回数を数えるメソッド
	 * @param str
	 * @return
	 */
	static int countOccurrences(String str, char target) {
		// 文字列内で指定された文字が出現する回数をカウント
		int count = 0;
		for (char charStr : str.toCharArray()) {
			if (charStr == target) {
				count++;
			}
		}
		return count;
	}
}

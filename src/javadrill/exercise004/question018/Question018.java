package javadrill.exercise004.question018;

/**
 * 文字列の配列が与えられた場合、その要素を逆順にして新しい配列を作成する
 */
public class Question018 {

	public static void main(String[] args) {
		String[] stringArray = { "あ", "い", "う", "え", "お" };

		String[] newStringArray = new String[stringArray.length];
		// // iが右から左に動く
		// for (int i = stringArray.length - 1; i >= 0; i--) {
		// newStringArray[i] = stringArray[stringArray.length - 1-i];
		// }
		// iが左から右に動く
		for (int i = 0; i < newStringArray.length; i++) {
			newStringArray[i] = stringArray[stringArray.length - 1 - i];
		}

		for (int i = 0; i < newStringArray.length; i++) {
			System.out.print(newStringArray[i]);
			if (i < newStringArray.length - 1) {
				System.out.print(",");
			}
		}

	}

}

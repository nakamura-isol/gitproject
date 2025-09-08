package javadrill.exercise013.question005;

public class Question005 {

	public static void main(String[] args) {
		String name = "恵梨香";
		int age = 30;
		// 文字列フォーマットを使用して文章生成
		String formattedString = String.format("名前は%sで、年齢は%d歳です。", name, age);
		// 結果の表示
		System.out.println(formattedString);
	}

}

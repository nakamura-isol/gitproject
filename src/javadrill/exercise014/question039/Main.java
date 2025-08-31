package javadrill.exercise014.question039;

public class Main extends Object{

	public static void main(String[] args) {
	
		
	     // Book オブジェクトを2つ作成
        Book book1 = new Book("吾輩は猫である", "夏目漱石");
        Book book2 = new Book("吾輩は猫である", "夏目漱石");

        // equals の結果を確認
        System.out.println("book1.equals(book2): " + book1.equals(book2));

        // hashCode の結果を確認
        System.out.println("book1.hashCode(): " +book1.hashCode());
        System.out.println("book2.hashCode(): " +book2.hashCode());

        // オブジェクト自体を出力（toStringをオーバーライドしていないとクラス名+ハッシュコードが表示される）
        System.out.println("book1: " +book1);
        System.out.println("book2: " +book2);

	}

}

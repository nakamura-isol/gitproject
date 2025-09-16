package javadrill.exercise018.question024;

public class Main extends Library {

	public static void main(String[] args) {
		Book book1 = new Book("こころ","夏目漱石",1914);
		Book book2 = new Book("吾輩は猫である","夏目漱石",1906);
		
		Library library = new Library();
		library.addBook(book1);
		
		// containsBookの確認
		System.out.println("book1 を含んでいる？ : "+library.containsBook(book1) );
		System.out.println("book2 を含んでいる？ : "+library.containsBook(book2) );
		
		library.addBook(book2);
		
		System.out.println("book1 を含んでいる？ : "+library.containsBook(book1) );
		System.out.println("book2 を含んでいる？ : "+library.containsBook(book2) );
		
		   // ライブラリの中身を確認
        System.out.println("同じ本を入れても重複しないか？ → books の数: " + library.books.size());
        
        Book book3 = new Book("吾輩は猫である","夏目漱石",1906);
        
        library.addBook(book3);
        System.out.println("book3 を含んでいる？ : "+library.containsBook(book3) );
        System.out.println("同じ本を入れても重複しないか？ → books の数: " + library.books.size());

	}

}

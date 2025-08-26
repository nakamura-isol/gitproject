package javadrill.exercise007.question014;

public class Main {

	public static void main(String[] args) {
		Book book1 = new Book("吾輩は猫である", "夏目漱石", 1905);
		Book book2 = new Book("雪国", "川端康成", 1947);
		Book book3 = new Book("ノルウェイの森", "村上春樹", 1987);

		
		// ライブラリに本を追加
		Library library = new Library();
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		System.out.println();
		library.displayBooks();
	}

}

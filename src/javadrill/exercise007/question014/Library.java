package javadrill.exercise007.question014;

import java.util.ArrayList;
import java.util.List;

public class Library {
	
	private List<Book> bookList = new ArrayList<>();

	/**
	 * 本追加メソッド
	 * @param book
	 */
	public void addBook(Book book) {
		bookList.add(book);
		System.out.println("本を追加しました: ");
		book.displayInfo();
	}

	/**
	 * ライブラリの本一覧表示メソッド
	 */
	public void displayBooks() {
		System.out.println("ライブラリにある本の一覧:");
		for (Book book : bookList) {
			book.displayInfo();
			System.out.println("---");
		}
	}
}

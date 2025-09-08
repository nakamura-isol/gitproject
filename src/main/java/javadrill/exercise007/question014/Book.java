package javadrill.exercise007.question014;

public class Book {
	String title;
	String author;
	int publicationYear;

	public Book(String title, String author, int publicationYear) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
	}

	public void displayInfo() {
		System.out.println("タイトル：" + this.title);
		System.out.println("著者：" + this.author);
		System.out.println("出版年：" + this.publicationYear);
	}
}

package javadrill.exercise007.question008;

public class Book {
	private String title;
	private String author;
	private int publishYear;

	Book(String title, String author, int publishYear) {
		this.title = title;
		this.author = author;
		this.publishYear = publishYear;

	}

	void displayInfo() {
		System.out.println("タイトル：" + getTitle());
		System.out.println("著者：" + getAuthor());
		System.out.println("出版年：" + getPublishedYear());

	}

	String getTitle() {
		return title;
	}

	void setTitle(String title) {
		this.title = title;
	}

	String getAuthor() {
		return author;
	}

	void setAuthor(String author) {
		this.author = author;
	}

	int getPublishedYear() {
		return publishYear;
	}

	void setPublishedYear(int publishedYear) {
		this.publishYear = publishedYear;
	}

}

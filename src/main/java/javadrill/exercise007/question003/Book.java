package javadrill.exercise007.question003;

public class Book {
	private String title;
	private String author;
	private int publishYear;
	
	Book(){
		title = "";
		author ="";
		publishYear = 9999;
		
	}
	
	void displayInfo() {
		System.out.println("タイトル："+getTitle());
		System.out.println("著者："+getAuthor());
		System.out.println("出版年："+getPublishedYear());

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPublishedYear() {
		return publishYear;
	}

	public void setPublishedYear(int publishedYear) {
		this.publishYear = publishedYear;
	}
}

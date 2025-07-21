package gitproject;

public class BookRental {
	private String title;
	private String date;

	public BookRental(String title, String date) {
		this.title = title;
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public String getDate() {
		return date;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
}

package javadrill.exercise018.question023;

public class Book{
	private String title;
	private String author;
	private int year;

	Book(String title, String author, int year) {
		this.title = title;
		this.author = author;
		this.year = year;
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

	int getYear() {
		return year;
	}

	void setYear(int year) {
		this.year = year;
	}
	@Override
	public boolean equals (Object obj) {
		   if (this == obj) {
	            return true;
	        }
		   if(obj == null || this.getClass() != obj.getClass()) {
			   return false;
		   }
		
		
		return false;
		
	}
	@Override
	  public int hashCode() {
        return 0;
    }
}

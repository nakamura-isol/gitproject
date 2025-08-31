package javadrill.exercise014.question039;

import java.util.Objects;

public class Book {

	private String title;
	private String author;
	private int year;

	Book(String title, String author) {
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

	public int hashCode() {
		return Objects.hash(title, author, year);
	}

	// equals メソッドもオーバーライドすることが推奨されます
	// equals の実装は hashCode の計算に関連しています
	@Override
	/**
	 * オブジェクトのハッシュコードを適切に計算する
	 * @param object
	 * @return
	 */
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		Book otherBook = (Book) object;
		return year == otherBook.year && Objects.equals(title, otherBook.title)
				&& Objects.equals(author, otherBook.author);

	}
}

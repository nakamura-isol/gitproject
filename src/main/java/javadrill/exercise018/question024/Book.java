package javadrill.exercise018.question024;

import java.util.Objects;

public class Book extends Object {

	private String title;
	private String author;
	private int publicationYear;

	Book(String title, String author, int publicationYear) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
	}

	/**
	 * Bookクラスのequalsメソッド
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}

		Book otherBook = (Book) obj;

		return this.title.equals(otherBook.getTitle()) && this.author.equals(otherBook.getAuthor())
				&& this.publicationYear == otherBook.getPublicationYear();

	}

	// /**
	// * BookクラスのhashCodeメソッド
	// */
	// @Override
	// public int hashCode() {
	// return Objects.hash(title,author,publicationYear);
	// }
	/**
	 * 異なる素数を使用してhashCodeを計算する（典型的な書き方）
	 */
	public int hashCode() {
		// 初期値に17を選ぶ（素数であることが好ましい）
		int result = 17;
		result = 31 * result + Objects.hashCode(title);
		result = 31 * result + Objects.hashCode(author);
		// int はそのまま
		result = 31 * result + publicationYear;
		return result;

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

	int getPublicationYear() {
		return publicationYear;
	}

	void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

}

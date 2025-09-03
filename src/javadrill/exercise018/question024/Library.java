package javadrill.exercise018.question024;

import java.util.HashSet;
import java.util.Set;

public class Library {
	  private Set<Book> books;

	     Library() {
	        this.books = new HashSet<>();
	    }

	     void addBook(Book book) {
	        books.add(book);
	    }

	     boolean containsBook(Book book) {
	        return books.contains(book);
	    }



}

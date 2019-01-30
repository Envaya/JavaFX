package ch.fhnw.oop2.module02.setrevisited;

import java.util.Objects;

/**
 * @author Dieter Holz
 */
public class Book {
    private final int isbn;

	public Book(int isbn) {
	    this.isbn = isbn;
	}

    public int getIsbn() {
        return isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return isbn == book.isbn;
    }

}

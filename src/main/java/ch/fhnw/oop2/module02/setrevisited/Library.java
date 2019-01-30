package ch.fhnw.oop2.module02.setrevisited;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Dieter Holz
 */
public class Library {
    private final Set<Book> allBooks = new HashSet<>();

    public void add(Book book) {
        allBooks.add(book);
    }

    public int size() {
        return allBooks.size();
    }

    public boolean contains(Book book){
        return allBooks.contains(book);
    }

    public Book get(int isbn) {
        for(Book b : allBooks){
            if (b.getIsbn() == isbn) {
                return b;
            }
        }
        return null;
    }
}

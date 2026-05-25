package behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

public class BookCollection {
    private final List<Book> books = new ArrayList<>();

    public void add(Book book) { books.add(book); }

    public BookIterator iterator() {
        return new BookIterator() {
            private int index = 0;
            @Override public boolean hasNext() { return index < books.size(); }
            @Override public Book next()       { return books.get(index++); }
        };
    }
}

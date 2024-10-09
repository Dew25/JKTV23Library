package ee.ivkhkdev.repository;

import ee.ivkhkdev.model.Book;

import java.util.List;

public interface BookRepository {
    void saveBook(Book book);
    List<Book> loadBooks();
}

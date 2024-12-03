package ee.ivkhkdev.repository;

import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends AppRepository<Book> {

    default public String getFilename() {
        return "books";
    }
}

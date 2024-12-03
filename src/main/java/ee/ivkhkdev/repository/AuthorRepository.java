package ee.ivkhkdev.repository;

import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends AppRepository<Author> {

    default public String getFilename() {
        return "authors";
    }
}

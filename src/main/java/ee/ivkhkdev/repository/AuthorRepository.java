package ee.ivkhkdev.repository;

import ee.ivkhkdev.interfaces.AppRepository;
import ee.ivkhkdev.model.Author;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepository implements AppRepository<Author> {

    public String getFilename() {
        return "authors";
    }
}

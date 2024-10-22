package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.AppHelperAuthorInput;
import ee.ivkhkdev.helpers.AppHelperBookInput;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.repository.Repository;

import java.util.List;

public class AuthorService {
    private final Input input;
    private final AppHelperAuthorInput appHelperAuthorInput;
    private final Repository<Author> repository;
    private List<Author> authors;

    public AuthorService(List<Author> authors, Input input, AppHelperAuthorInput appHelperAuthorInput, Repository<Author> repository) {
        this.input = input;
        this.repository = repository;
        this.appHelperAuthorInput = appHelperAuthorInput;
        this.authors = authors;

    }

    public boolean addAuthor(){
        Author author = appHelperAuthorInput.createAuthor();
        if(author != null) {
            authors.add(author);
            repository.save(authors);
            return true;
        }else{
            return false;
        }
    }

    public void authors() {
        appHelperAuthorInput.printAuthors();
    }

    public Repository<Author> getRepository() {
        return repository;
    }
}

package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.AppHelper;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.repository.Repository;

import java.util.List;

public class AuthorService implements Service<Author> {
    private final Input input;
    private final AppHelper<Author> appHelperAuthor;
    private final Repository<Author> repository;
    private List<Author> authors;

    public AuthorService(List<Author> authors, Input input, AppHelper<Author> appHelperAuthor, Repository<Author> repository) {
        this.input = input;
        this.repository = repository;
        this.appHelperAuthor = appHelperAuthor;
        this.authors = authors;

    }
    @Override
    public boolean add(){
        Author author = appHelperAuthor.create();
        if(author != null) {
            authors.add(author);
            repository.save(authors);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean edit() {
        return false;
    }

    @Override
    public boolean remove() {
        return false;
    }

    @Override
    public void print() {
        appHelperAuthor.printList();
    }
    @Override
    public Repository<Author> getRepository() {
        return repository;
    }
}

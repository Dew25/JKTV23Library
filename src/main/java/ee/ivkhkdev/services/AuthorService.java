package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.AppHelper;
import ee.ivkhkdev.input.Input;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.repository.Repository;

import java.util.List;

public class AuthorService implements Service<Author> {
    private final Input input;
    private final AppHelper<Author> appHelperAuthor;
    private final Repository<Author> repositoryAuthor;
    private List<Author> authors;

    public AuthorService(Input input, AppHelper<Author> appHelperAuthor, Repository<Author> repositoryAuthor) {
        this.input = input;
        this.repositoryAuthor = repositoryAuthor;
        this.appHelperAuthor = appHelperAuthor;
        this.authors = authors;

    }
    @Override
    public boolean add(){
        Author author = appHelperAuthor.create();
        if(author != null) {
            repositoryAuthor.save(author);
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
    public boolean print() {
        return appHelperAuthor.printList(repositoryAuthor.load());
    }

    @Override
    public Repository<Author> getRepository() {
        return repositoryAuthor;
    }
}

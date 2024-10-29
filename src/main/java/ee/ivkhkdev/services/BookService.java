package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.AppHelper;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.repository.Repository;
import ee.ivkhkdev.input.Input;

public class BookService implements Service<Book>{
    private final Input input;
    private final AppHelper<Book> appHelperBook;
    private final Repository<Book> repositoryBook;
    private final Service<Author> authorService;


    public BookService( Input input, AppHelper<Book> appHelperBook, Repository<Book> repositoryBook, Service<Author> authorService) {
        this.input = input;
        this.repositoryBook = repositoryBook;
        this.appHelperBook = appHelperBook;
        this.authorService = authorService;

    }
    @Override
    public boolean add(){
        Book book = appHelperBook.create();
        if(book != null) {
            repositoryBook.save(book);
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
        return  appHelperBook.printList(this.getRepository().load());
    }

    @Override
    public Repository<Book> getRepository() {
        return repositoryBook;
    }

}

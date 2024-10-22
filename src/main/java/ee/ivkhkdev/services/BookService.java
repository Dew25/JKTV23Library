package ee.ivkhkdev.services;

import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.helpers.AppHelperBookInput;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.repository.Repository;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.storages.Storage;

import java.util.List;

public class BookService {
    private final Input input;
    private final AppHelperBookInput appHelperBookInput;
    private final Repository<Book> repository;
    private List<Book> books;

    public BookService(List<Book> books, Input input, AppHelperBookInput appHelperBookInput, Repository<Book> repository) {
        this.input = input;
        this.repository = repository;
        this.appHelperBookInput = appHelperBookInput;
        this.books = books;

    }

    public boolean addBook(){
        Book book = appHelperBookInput.createBook();
        if(book != null) {
            books.add(book);
            repository.save(books);
            return true;
        }else{
            return false;
        }
    }

    public void books() {
        appHelperBookInput.printBooks();
    }

    public Repository<Book> getRepository() {
        return repository;
    }
}

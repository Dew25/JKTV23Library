package ee.ivkhkdev.services;

import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.helpers.AppHelperBookInput;
import ee.ivkhkdev.repository.Repository;
import ee.ivkhkdev.storages.Storage;
import ee.ivkhkdev.tools.Input;

public class BookService {
    private final Input input;
    private final Repository<Book> repository;

    public BookService(Input input, Repository<Book> repository) {
        this.input = input;
        this.repository = repository;

    }

    public boolean addBook(AppHelperBookInput appHelperBookInput){
        Book book = appHelperBookInput.createBook(input);
        if(book != null) {
            repository.save(book);
            return true;
        }else{
            return false;
        }
    }
}

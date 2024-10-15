package ee.ivkhkdev.services;

import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.helpers.AppHelperBookDataInput;
import ee.ivkhkdev.repository.Repository;
import ee.ivkhkdev.storages.Storage;
import ee.ivkhkdev.tools.Input;

public class BookService {
    private final Input input;
    private final Repository<Book> repository;

    public BookService(Input input) {
        this.input = input;
        this.repository = new Storage();

    }

    public boolean addBook(AppHelperBookDataInput appHelperBookDataInput){
        Book book = appHelperBookDataInput.createBook(input);
        if(book != null) {
            repository.save(book);
            return true;
        }else{
            return false;
        }
    }
}

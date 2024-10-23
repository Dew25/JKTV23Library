package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.AppHelper;
import ee.ivkhkdev.helpers.AppHelperBook;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.repository.Repository;
import ee.ivkhkdev.interfaces.Input;

import java.util.List;

public class BookService implements Service<Book>{
    private final Input input;
    private final AppHelper<Book> appHelperBook;
    private final Repository<Book> repository;
    private List<Book> books;

    public BookService(List<Book> books, Input input, AppHelper<Book> appHelperBook, Repository<Book> repository) {
        this.input = input;
        this.repository = repository;
        this.appHelperBook = appHelperBook;
        this.books = books;

    }
    @Override
    public boolean add(){
        Book book = appHelperBook.create();
        if(book != null) {
            books.add(book);
            repository.save(books);
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
        appHelperBook.printList();
    }
    @Override
    public Repository<Book> getRepository() {
        return repository;
    }
}

package ee.ivkhkdev.services;

import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.helpers.AppHelperBookDataInput;
import ee.ivkhkdev.repository.BookRepository;
import ee.ivkhkdev.tools.Input;

import java.util.Scanner;

public class BookService {
    private final Input input;
    private final BookRepository bookRepository;

    public BookService(Input input, BookRepository bookRepository) {
        this.input = input;
        this.bookRepository = bookRepository;

    }

    public boolean addBook(AppHelperBookDataInput appHelperBookDataInput){
        Book book = appHelperBookDataInput.createBook(input);
        if(book != null) {
            bookRepository.saveBook(book);
            return true;
        }else{
            return false;
        }
    }
}

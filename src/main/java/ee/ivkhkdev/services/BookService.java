package ee.ivkhkdev.services;

import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.helpers.BookDataInput;

import java.util.Scanner;

public class BookService {
    private final Scanner scanner;

    public BookService(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean addBook(BookDataInput bookDataInput){
        Book book = bookDataInput.createBook(scanner);
        if(book != null) {

            return true;
        }else{
            return false;
        }
    }
}

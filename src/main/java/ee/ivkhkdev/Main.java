package ee.ivkhkdev;

import ee.ivkhkdev.repository.BookRepository;
import ee.ivkhkdev.storages.StorageBook;
import ee.ivkhkdev.tools.Input;
import ee.ivkhkdev.tools.impl.ConsoleInput;

public class Main {
    public static void main(String[] args) {

        BookRepository bookRepository = new StorageBook();
        Input input = new ConsoleInput();

        App app = new App(input, bookRepository);
        app.run();
    }
}
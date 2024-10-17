package ee.ivkhkdev;

import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.repository.Repository;
import ee.ivkhkdev.storages.Storage;
import ee.ivkhkdev.tools.Input;
import ee.ivkhkdev.tools.impl.ConsoleInput;

public class Main {
    public static void main(String[] args) {
        Input input = new ConsoleInput();
       // Repository<Book> repository = new Storage<Book>("books");
        App app = new App(input);
        app.run();
    }
}
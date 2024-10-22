package ee.ivkhkdev;

import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.interfaces.impl.ConsoleInput;

public class Main {
    public static void main(String[] args) {

       // Repository<Book> repository = new Storage<Book>("books");
        App app = new App();
        app.run();
    }
}
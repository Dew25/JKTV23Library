package ee.ivkhkdev;

import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.interfaces.impl.ConsoleInput;

public class Main {
    public static void main(String[] args) {
        Input input = new ConsoleInput();
       // Repository<Book> repository = new Storage<Book>("books");
        App app = new App(input);
        app.run();
    }
}
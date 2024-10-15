package ee.ivkhkdev;

import ee.ivkhkdev.tools.Input;
import ee.ivkhkdev.tools.impl.ConsoleInput;

public class Main {
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        App app = new App(input);
        app.run();
    }
}
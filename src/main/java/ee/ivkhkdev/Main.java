package ee.ivkhkdev;

import ee.ivkhkdev.framework.Factory;
import ee.ivkhkdev.framework.JavaConfiguration;

public class Main {
    public static void main(String[] args) {
        Factory factory = Factory.getInstance(new JavaConfiguration());
        ((App) factory.getObject("app")).run();
    }
}
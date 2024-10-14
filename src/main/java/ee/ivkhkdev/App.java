package ee.ivkhkdev;

import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.repository.BookRepository;
import ee.ivkhkdev.services.BookService;
import ee.ivkhkdev.helpers.AppHelperBookDataInput;
import ee.ivkhkdev.services.UserService;
import ee.ivkhkdev.storages.StorageBook;
import ee.ivkhkdev.tools.Input;

import java.util.List;
import java.util.Scanner;

public class App {

    private final Input input;
    private Scanner scanner = new Scanner(System.in);
    private BookRepository bookRepository;

    public App(Input input, BookRepository bookRepository) {
        this.input = input;
        this.bookRepository = bookRepository;
    }
    public void run() {
        boolean repeat = true;
        System.out.println("--------------- JKTV23 библиотека --------------");
        do {
            System.out.println("Список задач: ");
            System.out.println("0. Выход из программы");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Добавить читателя");
            System.out.println("3. Список книг");
            System.out.println("4. Список читателей");
            System.out.println("5. Выдать книгу");
            System.out.println("6. Вернуть книгу");
            System.out.print("Выберите номер задачи из списка: ");
            int task = Integer.parseInt(input.nextLine());
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    BookService bookService = new BookService(input, bookRepository);
                    bookService.addBook(new AppHelperBookDataInput());
                    break;
                case 2:
                    UserService userService = new UserService(scanner);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Выберите номер задачи из списка!");
            }
        }while (repeat);
        System.out.println("До свидания!");

    }
}

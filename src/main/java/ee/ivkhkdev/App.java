package ee.ivkhkdev;

import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.repository.BookRepository;
import ee.ivkhkdev.services.BookService;
import ee.ivkhkdev.services.helpers.BookDataInput;
import ee.ivkhkdev.storages.StorageBook;
import java.util.List;
import java.util.Scanner;

public class App {
    public static List<Book> books;
    private Scanner scanner = new Scanner(System.in);
    private BookRepository bookRepository = new StorageBook();
    public App() {
        this.books = bookRepository.loadBooks();
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
            int task = Integer.parseInt(scanner.nextLine());
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    BookService bookService = new BookService(scanner);
                    bookService.addBook(new BookDataInput());
                    break;
                case 2:
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

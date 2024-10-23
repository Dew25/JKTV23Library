package ee.ivkhkdev;

import ee.ivkhkdev.helpers.*;
import ee.ivkhkdev.interfaces.impl.ConsoleInput;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.model.Register;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.repository.Repository;
import ee.ivkhkdev.services.*;
import ee.ivkhkdev.storages.Storage;
import ee.ivkhkdev.interfaces.Input;

import java.util.List;

public class App {
    List<Book> books;
    List<Author> authors;
    List<User> users;
    List<Register> registers;

    private final Input input;
    private final Repository<Book> repositoryBook;
    private final Repository<Author> repositoryAuthor;
    private final Repository<User> repositoryUser;
    private final Repository<Register> repositoryRegister;

    private final Service<Book> bookService;
    private final Service<Author> authorService;
    private final Service<User> userService;
    private final Service<Register> registerService;

    private final AppHelper<Book> appHelperBook;
    private final AppHelper<Author> appHelperAuthor;
    private final AppHelper<User> appHelperUser;
    private final AppHelper<Register> appHelperRegister;


    public App() {
        this.input = new ConsoleInput();
        this.repositoryBook = new Storage<>("books");
        this.repositoryAuthor = new Storage<>("authors");
        this.repositoryUser = new Storage<>("users");
        this.repositoryRegister = new Storage<>("registers");
        users = repositoryUser.load();
        authors = repositoryAuthor.load();
        books = repositoryBook.load();
        registers = repositoryRegister.load();
        this.appHelperAuthor = new AppHelperAuthor(input, authors);
        this.appHelperBook = new AppHelperBook(input,books, appHelperAuthor);
        this.appHelperUser = new AppHelperUser(input, users);
        this.bookService = new BookService(books, input, appHelperBook, repositoryBook);
        this.authorService = new AuthorService(authors, input, appHelperAuthor, repositoryAuthor);
        this.userService = new UserService(users, input, appHelperUser, repositoryUser);
        this.appHelperRegister = new AppHelperRegister(books,users,registers,input,userService,bookService);
        this.registerService = new RegisterService(registers, repositoryRegister, appHelperRegister);
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
            System.out.println("7. Добавить автора");
            System.out.print("Выберите номер задачи из списка: ");
            int task = Integer.parseInt(input.nextLine());
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    if(bookService.add()){
                        System.out.println("Книга добавлена");
                    } else {
                        System.out.println("Книгу добавить не удалось");
                    }
                    break;
                case 2:
                    if(userService.add()){
                        System.out.println("Читатель добавлен");
                    } else {
                        System.out.println("Читателя добавить не удалось");
                    }
                    break;
                case 3:
                    bookService.print();
                    break;
                case 4:
                    userService.print();
                    break;
                case 5:
                    if (registerService.add()) {
                        System.out.println("Книга выдана");
                    } else {
                        System.out.println("Книгу выдать не удалось");
                    }
                    break;
                case 6:
                    if (((RegisterService)registerService).returnBook()) {
                        System.out.println("Книга возвращена");
                    }else{
                        System.out.println("Книгу вернуть не удалось");
                    }
                    break;
                case 7:
                    if(authorService.add()){
                        System.out.println("Автор добавлен");
                    }else{
                        System.out.println("Автора добавить не удалось");
                    }
                    break;
                default:
                    System.out.println("Выберите номер задачи из списка!");
            }
        }while (repeat);
        System.out.println("До свидания!");

    }
}

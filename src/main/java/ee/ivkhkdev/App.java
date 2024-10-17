package ee.ivkhkdev;

import ee.ivkhkdev.helpers.AppHelperUserDataInput;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.repository.Repository;
import ee.ivkhkdev.services.BookService;
import ee.ivkhkdev.helpers.AppHelperBookInput;
import ee.ivkhkdev.services.UserService;
import ee.ivkhkdev.storages.Storage;
import ee.ivkhkdev.tools.Input;

public class App {

    Repository<User> repositoryUser;
    Repository<Book> repositoryBook;
    private final Input input;
    private BookService bookService;
    private UserService userService;
    private AppHelperBookInput appHelperBookInput;
    private AppHelperUserDataInput appHelperUserDataInput;

    public App(Input input) {
        this.input = input;
        repositoryUser = new Storage<>("users");
        repositoryBook = new Storage<>("books");
        this.bookService = new BookService(input,repositoryBook);
        this.userService = new UserService(input,repositoryUser);
        this.appHelperBookInput = new AppHelperBookInput();
        this.appHelperUserDataInput = new AppHelperUserDataInput();
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
                    if(bookService.addBook(appHelperBookInput)){
                        System.out.println("Книга добавлена");
                    }
                    break;
                case 2:
                    if(userService.addUser(new AppHelperUserDataInput())){
                        System.out.println("Читатель добавлен");
                    }
                    break;
                case 3:
                    bookService.books(appHelperBookInput,repositoryBook,appHelperBookInput);
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

package ee.ivkhkdev;

import ee.ivkhkdev.helpers.*;
import ee.ivkhkdev.input.Input;
import ee.ivkhkdev.input.ConsoleInput;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.model.Register;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.repository.Repository;
import ee.ivkhkdev.services.*;
import ee.ivkhkdev.repository.Storage;

public class Main {
    public static void main(String[] args) {
        final Input input = new ConsoleInput();
        final Repository<Book> repositoryBook = new Storage<>("books");
        final Repository<Author> repositoryAuthor = new Storage<>("authors");
        final Repository<User> repositoryUser = new Storage<>("users");
        final Repository<Register> repositoryRegister = new Storage<>("registers");
        final AppHelper<Author> appHelperAuthor = new AppHelperAuthor(input);
        final AppHelper<User> appHelperUser = new AppHelperUser(input);
        final Service<Author> authorService = new AuthorService(input, appHelperAuthor, repositoryAuthor);
        final Service<User> userService = new UserService(input, appHelperUser, repositoryUser);
        final AppHelper<Book> appHelperBook = new AppHelperBook(input, authorService);
        final Service<Book> bookService = new BookService(input, appHelperBook, repositoryBook, authorService);;
        final AppHelper<Register> appHelperRegister = new AppHelperRegister(input,userService,bookService);
        final Service<Register> registerService = new RegisterService(appHelperRegister,repositoryRegister);

        App app = new App(input, bookService,authorService,userService,registerService);
        app.run();
    }
}
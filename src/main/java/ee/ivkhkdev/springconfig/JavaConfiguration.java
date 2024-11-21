package ee.ivkhkdev.springconfig;

import ee.ivkhkdev.helpers.*;
import ee.ivkhkdev.input.ConsoleInput;
import ee.ivkhkdev.input.Input;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.model.Register;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.repository.Repository;
import ee.ivkhkdev.repository.Storage;
import ee.ivkhkdev.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfiguration {
//    @Bean
//    public Input input() {
//        return new ConsoleInput();
//    }

    @Bean
    public Repository<Book> repositoryBook() {
        return new Storage<>("books");
    }

    @Bean
    public Repository<Author> repositoryAuthor() {
        return new Storage("authors");
    }

    @Bean
    public Repository<User> repositoryUser() {
        return new Storage("users");
    }

    @Bean
    public Repository<Register> repositoryRegister() {
        return new Storage("registers");
    }
    @Bean
    public AppHelper<Author> appHelperAuthor(Input input){
        return new AppHelperAuthor(input);
    }
    @Bean
    public AppHelper<User> appHelperUser(Input input){
        return new AppHelperUser(input);
    }
    @Bean
    public Service<User> userService(Input input,AppHelper<User> appHelperUser, Repository<User> repositoryUser){
        return new UserService(input,appHelperUser,repositoryUser);
    }
    @Bean
    public Service<Author> authorService(Input input,AppHelper<Author> appHelperAuthor, Repository<Author> repositoryAuthor){
        return new AuthorService(input,appHelperAuthor,repositoryAuthor);
    }
    @Bean
    public AppHelper<Book> appHelperBook(Input input,Service<Author>authorService){
        return new AppHelperBook(input, authorService);
    }
    @Bean
    public Service<Book> bookService(Input input,AppHelper<Book>bookAppHelper,Repository<Book> bookRepository,Service<Author>authorService){
        return new BookService(input,bookAppHelper, bookRepository, authorService);
    }
    @Bean
    public AppHelper<Register> appHelperRegister(Input input, Service<User> userService,Service<Book> bookService){
        return new AppHelperRegister(input,userService,bookService);
    }
    @Bean
    public Service<Register> registerService(AppHelper<Register> registerAppHelper,Repository<Register>registerRepusitory){
        return new RegisterService(registerAppHelper,registerRepusitory);
    }
}



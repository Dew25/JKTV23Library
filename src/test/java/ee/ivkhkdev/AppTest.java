package ee.ivkhkdev;

import ee.ivkhkdev.helpers.AppHelperBookDataInput;
import ee.ivkhkdev.helpers.AppHelperUserDataInput;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.repository.Repository;
import ee.ivkhkdev.storages.Storage;
import ee.ivkhkdev.tools.Input;
import ee.ivkhkdev.tools.impl.ConsoleInput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class AppTest {

    Input inputMock;
    Repository repositoryMock;
    PrintStream defaultOut;
    ByteArrayOutputStream mockOut;
    @BeforeEach
    void setUp() {
        inputMock = Mockito.mock(ConsoleInput.class);
        repositoryMock = Mockito.mock(Storage.class);
        defaultOut = System.out;
        mockOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(mockOut));
    }

    @AfterEach
    void tearDown() {
        System.setOut(defaultOut);
    }

    @Test
    void runExit() {
        when(inputMock.nextLine()).thenReturn("0");
        App app = new App(inputMock);
        app.run();
        String expected = "До свидания!";
        String actual = mockOut.toString();
//        System.setOut(defaultOut);
//        System.out.println(actual);
        assertTrue(actual.contains(expected));
    }
    @Test
    void runAddBook(){
        when(inputMock.nextLine()).thenReturn("1","0");
        AppHelperBookDataInput appHelperBookDataInputMock = Mockito.mock(AppHelperBookDataInput.class);
//        BookService bookServiceMock = Mockito.mock(BookService.class);
        Author author = new Author("Lev","Tolstory");
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        Book book = new Book("Voina i mir", authors, 2000);
        when(appHelperBookDataInputMock.createBook(inputMock)).thenReturn(book);
//        when(bookServiceMock.addBook(appHelperBookDataInputMock.createBook(inputMock)).thenReturn(true);
//
//        List<Book> books = new ArrayList<>();
//        books.add(book);
//        when(((StorageBook) bookRepositoryMock).getBooks()).thenReturn(books);
        App app = new App(inputMock);
        app.run();
        String actualStr = mockOut.toString();
        String expectedStr = "Книга добавлена";
        assertTrue(actualStr.contains(expectedStr));

    }
    @Test
    void runAddUser(){
        when(inputMock.nextLine()).thenReturn("2","0");
        AppHelperUserDataInput appHelperUserDataInputMock = Mockito.mock(AppHelperUserDataInput.class);

        User user = new User("Ivan", "Ivanov", "123456", "ivan@jktv23.ee");
        List<User> users = new ArrayList<>();
        users.add(user);
        when(appHelperUserDataInputMock.createUser(inputMock)).thenReturn(user);
        App app = new App(inputMock);
        app.run();
        String actualStr = mockOut.toString();
        String expectedStr = "Читатель добавлен";
        assertTrue(actualStr.contains(expectedStr));
    }
}
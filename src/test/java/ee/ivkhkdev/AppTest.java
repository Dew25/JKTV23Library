package ee.ivkhkdev;

import ee.ivkhkdev.helpers.AppHelperBookInput;
import ee.ivkhkdev.helpers.AppHelperUserDataInput;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.repository.Repository;
import ee.ivkhkdev.services.BookService;
import ee.ivkhkdev.services.UserService;
import ee.ivkhkdev.storages.Storage;
import ee.ivkhkdev.tools.Input;
import ee.ivkhkdev.tools.impl.ConsoleInput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


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
        AppHelperBookInput appHelperBookInputMock = mock(AppHelperBookInput.class);
        Book bookMock = Mockito.mock(Book.class);
        when(appHelperBookInputMock.createBook(inputMock)).thenReturn(bookMock);
        Repository<Book> repositoryMock = Mockito.mock(Storage.class);
        BookService bookService = new BookService(inputMock, repositoryMock);
        boolean result = bookService.addBook(appHelperBookInputMock);
        verify(repositoryMock, times(1)).save(bookMock);
        assertTrue(result);
    }
    @Test
    void runAddUser(){
        User userMock = Mockito.mock(User.class);
        AppHelperUserDataInput appHelperUserInputMock = Mockito.mock(AppHelperUserDataInput.class);
        Repository<User> repositoryMock = mock(Storage.class);
        when(appHelperUserInputMock.createUser(inputMock)).thenReturn(userMock);
        UserService userService = new UserService(inputMock, repositoryMock);
        boolean result = userService.addUser(appHelperUserInputMock);
        verify(repositoryMock, times(1)).save(userMock);
        assertTrue(result);
    }
}
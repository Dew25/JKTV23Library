package ee.ivkhkdev;

import ee.ivkhkdev.repository.BookRepository;
import ee.ivkhkdev.storages.StorageBook;
import ee.ivkhkdev.tools.Input;
import ee.ivkhkdev.tools.impl.ConsoleInput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


class AppTest {
    Input inputMock;
    BookRepository bookRepositoryMock;
    PrintStream defaultOut;
    ByteArrayOutputStream mockOut;
    @BeforeEach
    void setUp() {
        inputMock = Mockito.mock(ConsoleInput.class);
        bookRepositoryMock = Mockito.mock(StorageBook.class);
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
        App app = new App(inputMock,bookRepositoryMock);
        app.run();
        String expected = "До свидания!";
        String actual = mockOut.toString();
//        System.setOut(defaultOut);
//        System.out.println(actual);
        assertTrue(actual.contains(expected));
    }
    void runAddBook(){

        assertTrue(actual.contains(expected));
    }
}
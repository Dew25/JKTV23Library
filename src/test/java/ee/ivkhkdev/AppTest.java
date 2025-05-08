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
    private Input inputMock;
    private BookRepository bookRepositoryMock;
    private PrintStream defaultOut;
    private ByteArrayOutputStream mockOut;
    private App app;

    @BeforeEach
    void setUp() {
        inputMock = Mockito.mock(ConsoleInput.class);
        bookRepositoryMock = Mockito.mock(StorageBook.class);
        defaultOut = System.out;
        mockOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(mockOut));
        app = new App(inputMock, bookRepositoryMock);
    }

    @AfterEach
    void tearDown() {
        System.setOut(defaultOut);
        mockOut.reset();
    }

    @Test
    void runExit() {
        when(inputMock.nextLine()).thenReturn("0");
        app.run();
        String expected = "До свидания!";
        String actual = mockOut.toString();
        assertTrue(actual.contains(expected));
    }

    @Test
    void runAddBook() {
        when(inputMock.nextLine())
                .thenReturn("1")  // Select add book option
                .thenReturn("Test Book")  // Book title
                .thenReturn("Test Author")  // Author
                .thenReturn("2023")  // Publication year
                .thenReturn("0");  // Exit

        app.run();
        String expected = "Книга добавлена";
        String actual = mockOut.toString();
        assertTrue(actual.contains(expected));
    }
}
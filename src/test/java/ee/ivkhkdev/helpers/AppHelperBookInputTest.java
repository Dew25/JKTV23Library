package ee.ivkhkdev.helpers;

import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.tools.Input;
import ee.ivkhkdev.tools.impl.ConsoleInput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AppHelperBookInputTest {
    Input inputMock;
    AppHelperBookInput appHelperBookInput = new AppHelperBookInput();
    @BeforeEach
    void setUp() {
        inputMock = Mockito.mock(ConsoleInput.class);

    }

    @AfterEach
    void tearDown() {
        inputMock = null;
        appHelperBookInput =null;
    }

    @Test
    void appHelperBookDataInputCreateBook() {
        when(inputMock.nextLine()).thenReturn("Voina i mir","1","Lev","Tolstoy","2000");
        Book actual = appHelperBookInput.createBook(inputMock);
        Author author = new Author("Lev","Tolstoy");
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        Book expected = new Book("Voina i mir", authors, 2000);
        assertTrue(actual.getTitle().equals(expected.getTitle()));
    }
}
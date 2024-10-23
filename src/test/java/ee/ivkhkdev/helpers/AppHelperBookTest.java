package ee.ivkhkdev.helpers;

import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.interfaces.impl.ConsoleInput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AppHelperBookTest {

    Input inputMock;
    List<Book> booksMock;
    AppHelperAuthor appHelperAuthorMock;
    AppHelperBook appHelperBook;

    @BeforeEach
    void setUp() {
        inputMock = Mockito.mock(ConsoleInput.class);
        booksMock = Mockito.mock(ArrayList.class);
        appHelperAuthorMock = Mockito.mock(AppHelperAuthor.class);
        appHelperBook = new AppHelperBook(inputMock,booksMock, appHelperAuthorMock);

    }

    @AfterEach
    void tearDown() {
        inputMock = null;
        booksMock =null;
        appHelperAuthorMock =null;
        appHelperBook =null;
    }

    @Test
    void createBookWithAddAuthors() {
        when(inputMock.nextLine()).thenReturn("Voina i mir","y");
        Book actual = appHelperBook.create();
        Book expected = null;
//        Author author = new Author("Lev","Tolstoy");
//        List<Author> authors = new ArrayList<>();
//        authors.add(author);
//        Book expected = new Book("Voina i mir", authors, 2000);
        assertTrue(actual == expected);
    }

    @Test
    void createBookWithoutAddAuthors() {
        when(inputMock.nextLine()).thenReturn("Voina i mir","n","1","1","2000");
        List<Author>authors = new ArrayList<>();
        authors.add(new Author("Lev","Tolstoy"));
        when(appHelperAuthorMock.getList()).thenReturn(authors);
        Book actual = appHelperBook.create();
        Book expected = new Book("Voina i mir", authors, 2000);

        assertEquals(actual.getTitle(), expected.getTitle());
    }


}
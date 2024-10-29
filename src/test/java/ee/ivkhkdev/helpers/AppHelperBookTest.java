package ee.ivkhkdev.helpers;

import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.input.Input;
import ee.ivkhkdev.input.ConsoleInput;
import ee.ivkhkdev.repository.Repository;
import ee.ivkhkdev.services.AuthorService;
import ee.ivkhkdev.services.Service;
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
    AppHelperBook appHelperBook;
    Service<Author> authorServiceMock;



    @BeforeEach
    void setUp() {
        inputMock = Mockito.mock(ConsoleInput.class);
        authorServiceMock = Mockito.mock(AuthorService.class);
        appHelperBook = new AppHelperBook(inputMock,authorServiceMock);

    }

    @AfterEach
    void tearDown() {
        inputMock = null;
        appHelperBook =null;
    }

    @Test
    void testCreate_NewBookCreatedSuccessfully() {
        Book book = new Book();
        List<Author> authors = new ArrayList<>();
        Author author = new Author("John", "Doe");
        authors.add(author);

        // Мокируем ввод пользователя
        when(inputMock.nextLine()).thenReturn("Book title", "n", "1", "1", "2000");
        when(authorServiceMock.getRepository().load()).thenReturn(authors);

        Book createdBook = appHelperBook.create();

        assertNotNull(createdBook);
        assertEquals("Book Title", createdBook.getTitle());
        assertEquals(2023, createdBook.getPublishedYear());
        assertEquals(1, createdBook.getAuthors().size());
        assertEquals(author, createdBook.getAuthors().get(0));
    }

//   // @Test
//    void createBookWithoutAddAuthors() {
////        when(inputMock.nextLine()).thenReturn("Voina i mir","n","1","1","2000");
////        List<Author>authors = new ArrayList<>();
////        authors.add(new Author("Lev","Tolstoy"));
////
////        Service<Author> authorServise = Mockito.mock(AuthorService.class);
////
////        when(repositoryAuthorMock.load()).thenReturn(authors);
////        Book actual = appHelperBook.create();
////        Book expected = new Book("Voina i mir", authors, 2000);
////
////        assertEquals(actual.getTitle(), expected.getTitle());
//    }


}
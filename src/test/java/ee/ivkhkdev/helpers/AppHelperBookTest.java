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
    private Repository<Author> authorRepository;


    @BeforeEach
    void setUp() {
        inputMock = Mockito.mock(ConsoleInput.class);
        authorServiceMock = Mockito.mock(AuthorService.class);
        authorRepository=Mockito.mock(Repository.class);
        when(authorServiceMock.getRepository()).thenReturn(authorRepository);
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
        Author author = new Author("Lev", "Tolstoy");
        authors.add(author);

        // Мокируем ввод пользователя
        when(inputMock.nextLine()).thenReturn("Voina i mir", "n", "1", "1", "2000");
        when(authorServiceMock.getRepository().load()).thenReturn(authors);

        Book createdBook = appHelperBook.create();

        assertNotNull(createdBook);
        assertEquals("Voina i mir", createdBook.getTitle());
        assertEquals(2000, createdBook.getPublishedYear());
        assertEquals(1, createdBook.getAuthors().size());
        assertEquals(author, createdBook.getAuthors().get(0));
    }
    @Test
    void testCreate_CreationCancelledByAuthor(){
        when(inputMock.nextLine()).thenReturn("Voina i mir","y");
        Book createdBook = appHelperBook.create();
        assertNull(createdBook);
    }
    @Test
    void testPrintList_WithBooks(){
        List<Book> books = new ArrayList<>();
        Author author = new Author("Lev","Tolstoy");
        Book book = new Book();
        book.setPublishedYear(2000);
        book.setTitle("Voina i mir");
        book.getAuthors().add(author);
        books.add(book);
        boolean result = appHelperBook.printList(books);
        assertTrue(result);
    }
    @Test
    void testPrintList_EmptyList(){
        List<Book> emptyBooks = new ArrayList<>();
        boolean result = appHelperBook.printList(emptyBooks);
        assertFalse(result);
    }

}
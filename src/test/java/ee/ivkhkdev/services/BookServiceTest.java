package ee.ivkhkdev.services;

import ee.ivkhkdev.interfaces.AppHelperBook;
import ee.ivkhkdev.input.Input;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {
    private Input input;
    private AppHelperBook appHelperBook;
    private BookRepository repositoryBook;
    private AppService<Author> authorService;
    private BookService bookService;

    @BeforeEach
    void setUp() {
        input = mock(Input.class);
        appHelperBook = mock(AppHelperBook.class);
        repositoryBook = mock(BookRepository.class);
        authorService = mock(AppService.class);
        bookService = new BookService(input, appHelperBook, repositoryBook, authorService);
    }
    @Test
    void add_WhenBookIsCreated_ShouldSaveBookAndReturnTrue() {
        // Arrange
        Book book = new Book();
        when(appHelperBook.create()).thenReturn(book);

        // Act
        boolean result = bookService.add();

        // Assert
        assertTrue(result);
        verify(repositoryBook, times(1)).save(book);
    }
    @Test
    void add_WhenBookIsNotCreated_ShouldNotSaveBookAndReturnFalse() {
        // Arrange
        when(appHelperBook.create()).thenReturn(null);

        // Act
        boolean result = bookService.add();

        // Assert
        assertFalse(result);
        verify(repositoryBook, never()).save(any(Book.class));
    }
    @Test
    void print_ShouldCallPrintListWithLoadedBooks() {
        // Arrange
        List<Book> books = List.of(new Book(), new Book());
        when(repositoryBook.load()).thenReturn(books);
        when(appHelperBook.printList(books)).thenReturn(true);
        // Act
        boolean result = bookService.print();

        // Assert
        assertTrue(result);
        verify(appHelperBook, times(1)).printList(books);
    }
    @Test
    void print_ShouldCallPrintListWithNotLoadedBooks() {
        // Arrange
        List<Book> books = null;
        when(repositoryBook.load()).thenReturn(books);
        when(appHelperBook.printList(books)).thenReturn(false);
        // Act
        boolean result = bookService.print();

        // Assert
        assertFalse(result);
        verify(appHelperBook, times(1)).printList(books);
    }

}
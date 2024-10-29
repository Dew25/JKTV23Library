package ee.ivkhkdev.helpers;

import ee.ivkhkdev.input.Input;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.model.Register;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.repository.Repository;
import ee.ivkhkdev.services.Service;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AppHelperRegisterTest {
    AppHelperRegister appHelperRegister;
    Input input;
    Service<User> userService;
    Service<Book> bookService;
    Repository<User> userRepository;
    Repository<Book> bookRepository;
    @BeforeEach
    void setUp() {
        input = mock(Input.class);
        userService = mock(Service.class);
        bookService = mock(Service.class);
        userRepository = mock(Repository.class);
        bookRepository = mock(Repository.class);

        when(userService.getRepository()).thenReturn(userRepository);
        when(bookService.getRepository()).thenReturn(bookRepository);

        appHelperRegister = new AppHelperRegister(input, userService, bookService);
    }


    @Test
    void testCreate_SuccessfulCreation() {
        User user = new User("Ivan","Ivanov","565656","ivan@ivkhk.ee");
        List<Author>authors = new ArrayList<>();
        authors.add(new Author("Lev","Tolstoy"));
        Book book = new Book("Voina i mir", authors,2000);
        List<User> users = List.of(user);
        List<Book> books = List.of(book);
        when(userService.print()).thenReturn(true);
        when(input.nextLine()).thenReturn("1", "1");
        when(userRepository.load()).thenReturn(users);
        when(bookService.print()).thenReturn(true);
        when(bookRepository.load()).thenReturn(books);

        Register register = appHelperRegister.create();

        assertNotNull(register);
        assertEquals(user, register.getUser());
        assertEquals(book, register.getBook());
        assertEquals(LocalDate.now(), register.getBookBorrowDate());
    }
    @Test
    public void testCreate_NoUsers() {
        when(userService.print()).thenReturn(false);
        Register register = appHelperRegister.create();
        assertNull(register);
    }
    @Test
    public void testCreate_NoBooks() {
        User user = new User("Ivan","Ivanov","565656","ivan@ivkhk.ee");
        List<User> users = List.of(user);

        when(userService.print()).thenReturn(true);
        when(input.nextLine()).thenReturn("1");
        when(userRepository.load()).thenReturn(users);
        when(bookService.print()).thenReturn(false);

        Register register = appHelperRegister.create();

        assertNull(register);
    }
    @Test
    public void testPrintList_WithUnreturnedBooks() {
        List<Author>authors = new ArrayList<>();
        authors.add(new Author("Lev","Tolstoy"));
        Book book = new Book("Voina i mir",authors,2000 );
        User user = new User("Ivan","Ivanov","565656","ivan@ivkhk.ee");

        Register register = new Register();
        register.setBook(book);
        register.setUser(user);
        register.setBookBorrowDate(LocalDate.now());

        List<Register> registers = List.of(register);

        boolean result = appHelperRegister.printList(registers);

        assertTrue(result);
    }
    @Test
    public void testPrintList_NoUnreturnedBooks() {
        List<Author>authors = new ArrayList<>();
        authors.add(new Author("Lev","Tolstoy"));
        Book book = new Book("Voina i mir",authors,2000 );
        User user = new User("Ivan","Ivanov","565656","ivan@ivkhk.ee");

        Register register = new Register();
        register.setBook(book);
        register.setUser(user);
        register.setBookBorrowDate(LocalDate.now());
        register.setReturnBookDate(LocalDate.now());  // Книга возвращена

        List<Register> registers = List.of(register);

        boolean result = appHelperRegister.printList(registers);

        assertFalse(result);
    }

    @Test
    public void testReturnBookDialog_SuccessfulReturn() {
        List<Author>authors = new ArrayList<>();
        authors.add(new Author("Lev","Tolstoy"));
        Book book = new Book("Voina i mir",authors,2000 );
        User user = new User("Ivan","Ivanov","565656","ivan@ivkhk.ee");

        Register register = new Register();
        register.setBook(book);
        register.setUser(user);
        register.setBookBorrowDate(LocalDate.now());

        List<Register> registers = new ArrayList<>(List.of(register));
        appHelperRegister.printList(registers);
        when(input.nextLine()).thenReturn("1");

        List<Register> updatedRegisters = appHelperRegister.returnBookDialog(registers);

        assertNotNull(updatedRegisters);
        assertNotNull(updatedRegisters.get(0).getReturnBookDate());
        assertEquals(LocalDate.now(), updatedRegisters.get(0).getReturnBookDate());
    }

    @Test
    public void testReturnBookDialog_NoUnreturnedBooks() {
        List<Register> registers = new ArrayList<>();
        appHelperRegister.printList(registers);
        List<Register> result = appHelperRegister.returnBookDialog(registers);
        assertNull(result);
    }
}
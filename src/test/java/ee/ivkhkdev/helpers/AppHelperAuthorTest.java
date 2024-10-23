package ee.ivkhkdev.helpers;

import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.model.Author;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AppHelperAuthorTest {

    Input inputMock;
    Author authorMock;
    List<Author> authors;
    Author author;
    AppHelperAuthor appHelperAuthor;
    PrintStream outDefault;
    ByteArrayOutputStream outMock;

    @BeforeEach
    void setUp() {
        outDefault = System.out;
        outMock = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outMock));
        inputMock = Mockito.mock(Input.class);
        authorMock = Mockito.mock(Author.class);
        author = new Author("Lev","Tolstoy");
        authors = new ArrayList<>();
        authors.add(author);
        appHelperAuthor = new AppHelperAuthor(inputMock,authors);
    }

    @AfterEach
    void tearDown() {
        inputMock=null;
        authorMock=null;
        authors=null;
        author=null;
        System.setOut(outDefault);
    }

    @Test
    void create() {
        when(inputMock.nextLine()).thenReturn("Lev","Tolstoy");
        Author actual = appHelperAuthor.create();
        assertEquals(actual.getFirstname(),author.getFirstname());
        assertEquals(actual.getLastname(),author.getLastname());
    }

    @Test
    void printList() {
        appHelperAuthor.printList();
        String expectid ="Lev Tolstoy";
//        System.setOut(outDefault);
//        System.out.println(outMock.toString());
        assertTrue(outMock.toString().contains(expectid));
    }

    @Test
    void getList() {
        List<Author> actual = appHelperAuthor.getList();
        List<Author> expectid = authors;
        assertTrue(actual.get(0).getFirstname().contains(expectid.get(0).getFirstname()));
    }
}
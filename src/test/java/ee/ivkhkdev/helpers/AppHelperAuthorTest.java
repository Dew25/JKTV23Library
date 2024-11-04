package ee.ivkhkdev.helpers;

import ee.ivkhkdev.input.Input;
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
        appHelperAuthor = new AppHelperAuthor(inputMock);
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
        appHelperAuthor.printList(authors);
        String expectid ="Lev Tolstoy";
//        System.setOut(outDefault);
//        System.out.println(outMock.toString());
        assertTrue(outMock.toString().contains(expectid));
    }
    @Test
    void editAuthor_WithReturnEditedAuthors(){
        List<Author> authors = List.of(new Author("firsname","lastname"));
        when(inputMock.nextLine()).thenReturn("1","y","firstname2","y","lastname2");
        List<Author> resultAuthors = appHelperAuthor.editEntities(authors);
        assertEquals(resultAuthors.get(0).getFirstname(), "firstname2");
        assertEquals(resultAuthors.get(0).getLastname(), "lastname2");
    }
    @Test
    void editAuthor_WithReturnNotEditedAuthors(){
        List<Author> authors = List.of(new Author("firstname","lastname"));
        when(inputMock.nextLine()).thenReturn("1","n","n");
        List<Author> resultAuthors = appHelperAuthor.editEntities(authors);
        assertEquals(resultAuthors.get(0).getFirstname(), "firstname");
        assertEquals(resultAuthors.get(0).getLastname(), "lastname");
    }


}
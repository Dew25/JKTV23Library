package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.AppHelper;
import ee.ivkhkdev.input.Input;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.repository.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthorServiceTest {
    private Input input;
    private AppHelper<Author> appHelperAuthor;
    private Repository<Author> repositoryAuthor;
    private AuthorService authorService;

    @BeforeEach
    void setUp() {
        input = mock(Input.class);
        appHelperAuthor = mock(AppHelper.class);
        repositoryAuthor = mock(Repository.class);
        authorService = new AuthorService(input, appHelperAuthor, repositoryAuthor);
    }
    @Test
    void add_WhenAuthorIsCreated_ShouldSaveAuthorAndReturnTrue() {
        // Arrange
        Author author = new Author();
        when(appHelperAuthor.create()).thenReturn(author);

        // Act
        boolean result = authorService.add();

        // Assert
        assertTrue(result);
        verify(repositoryAuthor, times(1)).save(author);
    }
    @Test
    void add_WhenAuthorIsNotCreated_ShouldNotSaveAuthorAndReturnFalse() {
        // Arrange
        when(appHelperAuthor.create()).thenReturn(null);

        // Act
        boolean result = authorService.add();

        // Assert
        assertFalse(result);
        verify(repositoryAuthor, never()).save(any(Author.class));
    }
    @Test
    void print_ShouldCallPrintListWithLoadedAuthors() {
        // Arrange
        List<Author> authors = List.of(new Author(), new Author());
        when(repositoryAuthor.load()).thenReturn(authors);
        when(appHelperAuthor.printList(authors)).thenReturn(true);
        // Act
        boolean result = authorService.print();

        // Assert
        assertTrue(result);
        verify(appHelperAuthor, times(1)).printList(authors);
    }
    @Test
    void getRepository_ShouldReturnRepository() {
        // Act
        Repository<Author> result = authorService.getRepository();

        // Assert
        assertTrue(result == repositoryAuthor);
    }
    @Test
    void edit_withTrue(){
        List<Author> authors= List.of(new Author("Lev","Tolstoy"));
        List<Author> expectedAuthors= List.of(new Author("Lev1","Tolstoy1"));
        when(appHelperAuthor.editEntities(authors)).thenReturn(expectedAuthors);
        List<Author> result = appHelperAuthor.editEntities(authors);
        assertEquals(result.get(0).getFirstname(),expectedAuthors.get(0).getFirstname());

    }@Test
    void edit_withFalse(){

    }

}
package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.AppHelper;
import ee.ivkhkdev.input.Input;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.repository.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {
    private Input input;
    private AppHelper<User> appHelperUser;
    private Repository<User> repositoryUser;
    private UserService userService;

    @BeforeEach
    void setUp() {
        input = mock(Input.class);
        appHelperUser = mock(AppHelper.class);
        repositoryUser = mock(Repository.class);
        userService = new UserService(input, appHelperUser, repositoryUser);
    }
    @Test
    void add_WhenUserIsCreated_ShouldSaveUserAndReturnTrue() {
        // Arrange
        User user = new User();
        when(appHelperUser.create()).thenReturn(user);
        when(repositoryUser.load()).thenReturn(List.of()); // Mock loading users

        // Act
        boolean result = userService.add();

        // Assert
        assertTrue(result);
        verify(repositoryUser, times(1)).save(user);
    }
    @Test
    void add_WhenUserIsNotCreated_ShouldNotSaveUserAndReturnFalse() {
        // Arrange
        when(appHelperUser.create()).thenReturn(null);

        // Act
        boolean result = userService.add();

        // Assert
        assertFalse(result);
        verify(repositoryUser, never()).save(any(User.class));
    }
    @Test
    void print_ShouldCallPrintListWithLoadedUsers() {
        // Arrange
        List<User> users = List.of(new User(), new User());
        when(repositoryUser.load()).thenReturn(users);
        when(appHelperUser.printList(users)).thenReturn(true);
        // Act
        boolean result = userService.print();

        // Assert
        assertTrue(result);
        verify(appHelperUser, times(1)).printList(users);
    }
    @Test
    void getRepository_ShouldReturnRepository() {
        // Act
        Repository<User> result = userService.getRepository();

        // Assert
        assertTrue(result == repositoryUser);
    }
}
package ee.ivkhkdev.helpers;

import ee.ivkhkdev.input.Input;
import ee.ivkhkdev.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AppHelperUserTest {
    private AppHelperUser appHelperUser;
    private Input input;
    @BeforeEach
    void setUp() {
        input = mock(Input.class);
        appHelperUser = new AppHelperUser(input);
    }

    @Test
    public void testCreate_UserCreatedSuccessfully() {
        // Мокаем вводные данные
        when(input.nextLine()).thenReturn("John", "Doe", "1234567890", "john.doe@example.com");

        // Создаем пользователя
        User user = appHelperUser.create();

        // Проверяем, что пользователь был создан и данные соответствуют введенным
        assertNotNull(user);
        assertEquals("John", user.getFirstname());
        assertEquals("Doe", user.getLastname());
        assertEquals("1234567890", user.getPhone());
        assertEquals("john.doe@example.com", user.getEmail());
    }

    @Test
    public void testPrintList_WithUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("John", "Doe", "1234567890", "john.doe@example.com"));
        users.add(new User("Jane", "Smith", "0987654321", "jane.smith@example.com"));

        // Проверяем, что метод возвращает true и печатает список, если пользователи присутствуют
        assertTrue(appHelperUser.printList(users));
    }

    @Test
    public void testPrintList_EmptyList() {
        List<User> users = new ArrayList<>();
        // Проверяем, что метод возвращает false и выводит сообщение, если список пуст
        assertFalse(appHelperUser.printList(users));
    }

    @Test
    public void testPrintList_NullList() {
        // Проверяем, что метод возвращает false и выводит сообщение, если передан null
        assertFalse(appHelperUser.printList(null));
    }
}
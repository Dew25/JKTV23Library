package ee.ivkhkdev.helpers;

import ee.ivkhkdev.model.User;
import ee.ivkhkdev.tools.Input;
import ee.ivkhkdev.tools.impl.ConsoleInput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AppHelperUserDataInputTest {

    Input inputMock;
    AppHelperUserDataInput appHelperUserDataInput = new AppHelperUserDataInput();
    @BeforeEach
    void setUp() {
        inputMock = Mockito.mock(ConsoleInput.class);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createUser() {
        when(inputMock.nextLine()).thenReturn("Ivan", "Ivanov","123456","ivan@jktv23.ee");
        User actual = appHelperUserDataInput.createUser(inputMock);
        User expected = new User("Ivan", "Ivanov","123456","ivan@jktv23.ee");
        assertTrue(actual.getFirstname().equals(expected.getFirstname()));
        assertTrue(actual.getLastname().equals(expected.getLastname()));
        assertTrue(actual.getPhone().equals(expected.getPhone()));
    }
}
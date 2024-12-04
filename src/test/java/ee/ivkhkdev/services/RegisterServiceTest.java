package ee.ivkhkdev.services;

import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.helpers.AppHelperRegisterImpl;
import ee.ivkhkdev.interfaces.AppHelperRegister;
import ee.ivkhkdev.model.Register;
import ee.ivkhkdev.repository.RegisterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RegisterServiceTest {
    private AppHelperRegister appHelperRegister;
    private RegisterRepository repositoryRegister;
    private RegisterService registerService;

    @BeforeEach
    void setUp() {
        appHelperRegister = mock(AppHelperRegister.class); // Using AppHelperRegisterImpl mock
        repositoryRegister = mock(RegisterRepository.class);
        registerService = new RegisterService(appHelperRegister, repositoryRegister);
    }
    @Test
    void add_WhenRegisterIsCreated_ShouldSaveRegisterAndReturnTrue() {
        // Arrange
        Register register = new Register();
        when(appHelperRegister.create()).thenReturn(register);

        // Act
        boolean result = registerService.add();

        // Assert
        assertTrue(result);
        verify(repositoryRegister, times(1)).save(register);
    }
    @Test
    void add_WhenRegisterIsNotCreated_ShouldNotSaveRegisterAndReturnFalse() {
        // Arrange
        when(appHelperRegister.create()).thenReturn(null);

        // Act
        boolean result = registerService.add();

        // Assert
        assertFalse(result);
        verify(repositoryRegister, never()).save(any(Register.class));
    }
    @Test
    void print_ShouldCallPrintListWithLoadedRegisters() {
        // Arrange
        List<Register> registers = List.of(new Register(), new Register());
        when(repositoryRegister.load()).thenReturn(registers);
        when(appHelperRegister.printList(registers)).thenReturn(true);
        // Act
        boolean result = registerService.print();

        // Assert
        assertTrue(result);
        verify(appHelperRegister, times(1)).printList(registers);
    }

    @Test
    void returnBook_WhenRegisterListIsNotNull_ShouldSaveAllAndReturnTrue() {
        // Arrange
        List<Register> registers = List.of(new Register(), new Register());
        when(((AppHelperRegisterImpl) appHelperRegister).returnBookDialog(anyList())).thenReturn(registers);

        // Act
        boolean result = registerService.returnBook();

        // Assert
        assertTrue(result);
        verify(repositoryRegister, times(1)).saveAll(registers);
    }
    @Test
    void returnBook_WhenRegisterListIsNull_ShouldNotSaveAndReturnFalse() {
        // Arrange
        when(((AppHelperRegisterImpl) appHelperRegister).returnBookDialog(anyList())).thenReturn(null);

        // Act
        boolean result = registerService.returnBook();

        // Assert
        assertFalse(result);
        verify(repositoryRegister, never()).saveAll(anyList());
    }
}
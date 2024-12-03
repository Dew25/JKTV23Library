package ee.ivkhkdev.helpers;

import ee.ivkhkdev.helpers.interfaces.AppHelper;
import ee.ivkhkdev.helpers.interfaces.AppHelperRegister;
import ee.ivkhkdev.input.Input;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.model.Register;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.repository.BookRepository;
import ee.ivkhkdev.repository.UserRepository;
import ee.ivkhkdev.services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
@Component
public class AppHelperRegisterImpl implements AppHelperRegister {

    @Autowired private  Input input;
    @Autowired private  AppService<User> userService;
    @Autowired private  AppService<Book> bookService;
    @Autowired private UserRepository userRepository;
    @Autowired private BookRepository bookRepository;

    @Override
    public Register create() {
        try {
            Register register = new Register();
            if(!userService.print()) {
                System.out.println("Нет пользователей");
                return null;
            };
            System.out.print("Введите номер пользователя из списка: ");
            int numberUser = Integer.parseInt(input.nextLine());
            User user = userRepository.load().get(numberUser-1);
            if(!bookService.print()){
                System.out.println("Нет книг");
                return null;
            };
            System.out.print("Введите номер книги из списка: ");
            int numberBook = Integer.parseInt(input.nextLine());
            Book book = bookRepository.load().get(numberBook-1);
            register.setUser(user);
            register.setBook(book);
            register.setBookBorrowDate(LocalDate.now());
            return register;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean printList(List<Register> registers){
        int numberBooks = 0;
        System.out.println(" --- Список выданных книг --- ");
        for (int i = 0; i < registers.size(); i++){
            if (registers.get(i).getReturnBookDate() != null){
                continue;
            }
            System.out.printf("%d. %s. %s. %d%n",
                    i+1,
                    registers.get(i).getBook().getTitle(),
                    Arrays.toString(registers.get(i).getBook().getAuthors().toArray()),
                    registers.get(i).getBook().getPublishedYear()

            );
            numberBooks++;
        }
        System.out.println(" --- Конец списка --- ");
        if(numberBooks < 1){
            return false;
        }else{
            return true;
        }

    }

    @Override
    public List<Register> editEntities(List<Register> entities) {
        return List.of();
    }

    public List<Register> returnBookDialog(List<Register> registers) {
        try {
            if(!this.printList(registers)) return null;
            System.out.print("Выберите номер возвращаемой книги: ");
            int numberReturnBookRegister = Integer.parseInt(input.nextLine());
            registers.get(numberReturnBookRegister - 1).setReturnBookDate(LocalDate.now());
            return registers;
        } catch (Exception e) {
            return null;
        }
    }
}

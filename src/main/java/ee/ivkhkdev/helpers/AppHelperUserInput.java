package ee.ivkhkdev.helpers;

import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.interfaces.Input;

import java.util.Arrays;
import java.util.List;

public class AppHelperUserInput {
    public User createUser(Input input){
        User user = new User();
        System.out.print("Имя: ");
        user.setFirstname(input.nextLine());
        System.out.print("Фамилия: ");
        user.setLastname(input.nextLine());
        System.out.print("Телефон: ");
        user.setPhone(input.nextLine());
        System.out.print("email: ");
        user.setEmail(input.nextLine());
        return user;
    }
    public void printUsers(List<User> entities) {
        if (entities.isEmpty()) {
            System.out.println(" --- Список читателей пуст --- ");
        } else {
            System.out.println(" --- Список читателей --- ");
            for (int i = 0; i < entities.size(); i++) {
                System.out.printf("%d. %s. %s. %s. %s%n",
                        i + 1,
                        entities.get(i).getFirstname(),
                        entities.get(i).getLastname(),
                        entities.get(i).getPhone(),
                        entities.get(i).getEmail()
                );
            }
            System.out.println(" --- Конец списка --- ");
        }
    }
}

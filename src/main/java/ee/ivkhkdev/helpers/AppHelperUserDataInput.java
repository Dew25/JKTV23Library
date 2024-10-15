package ee.ivkhkdev.helpers;

import ee.ivkhkdev.model.User;
import ee.ivkhkdev.tools.Input;

import java.util.Scanner;

public class AppHelperUserDataInput {
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
}

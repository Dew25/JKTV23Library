package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.AppHelperUserDataInput;
import ee.ivkhkdev.model.User;

import java.util.Scanner;

public class UserService {
    private final Scanner scanner;

    public UserService(Scanner scanner) {
        this.scanner = scanner;
    }
    public boolean addUser(AppHelperUserDataInput appHelperUserDataInput){
        User user = appHelperUserDataInput.createUser(scanner);
        if(user != null){
            return true;
        }else{
            return false;
        }
    }

}

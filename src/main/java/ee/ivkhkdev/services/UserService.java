package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.AppHelperUserDataInput;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.repository.Repository;
import ee.ivkhkdev.storages.Storage;
import ee.ivkhkdev.tools.Input;

import java.util.Scanner;

public class UserService {
    private final Input input;

    public UserService(Input input) {
        this.input = input;
    }
    public boolean addUser(AppHelperUserDataInput appHelperUserDataInput){
        User user = appHelperUserDataInput.createUser(input);
        if(user != null){
            Repository<User> repository = new Storage<User>();
            repository.save(user);
            return true;
        }else{
            return false;
        }
    }

}

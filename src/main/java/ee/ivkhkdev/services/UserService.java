package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.AppHelperUserDataInput;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.repository.Repository;
import ee.ivkhkdev.storages.Storage;
import ee.ivkhkdev.tools.Input;

import java.util.Scanner;

public class UserService {
    private final Input input;
    private final Repository<User> repository;

    public UserService(Input input, Repository<User> repository) {
        this.input = input;
        this.repository = repository;
    }
    public boolean addUser(AppHelperUserDataInput appHelperUserDataInput){
        User user = appHelperUserDataInput.createUser(input);
        if(user != null){
            repository.save(user);
            return true;
        }else{
            return false;
        }
    }

}

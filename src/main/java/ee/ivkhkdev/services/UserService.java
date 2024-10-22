package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.AppHelperUserInput;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.repository.Repository;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.storages.Storage;

import java.util.List;

public class UserService {
    private final Input input;
    private final AppHelperUserInput appHelperUserInput;
    private final Repository<User> repository;
    private final List<User> users;

    public UserService(List<User> users, Input input, AppHelperUserInput appHelperUserInput, Repository<User> repository) {
        this.users = users;
        this.input = input;
        this.appHelperUserInput = appHelperUserInput;
        this.repository = repository;
    }
    public boolean addUser(){
        User user = appHelperUserInput.createUser();
        if(user != null){
            users.add(user);
            repository.save(users);
            return true;
        }else{
            return false;
        }
    }

    public void users() {
        appHelperUserInput.printUsers();
    }

    public Repository<User> getRepository() {
        return repository;
    }
}

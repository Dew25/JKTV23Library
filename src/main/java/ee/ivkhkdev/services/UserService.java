package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.AppHelper;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.repository.Repository;
import ee.ivkhkdev.input.Input;

import java.util.List;

public class UserService implements Service<User>{
    private final Input input;
    private final AppHelper<User> appHelperUser;
    private final Repository<User> repositoryUser;

    public UserService(Input input, AppHelper<User> appHelperUser, Repository<User> repositoryUser) {
        this.input = input;
        this.appHelperUser = appHelperUser;
        this.repositoryUser = repositoryUser;
    }
    @Override
    public boolean add(){
        User user = appHelperUser.create();
        List<User> users = repositoryUser.load();
        if(user == null) {
            return false;
        }
        repositoryUser.save(user);
        return true;

    }

    @Override
    public boolean edit() {
        return false;
    }

    @Override
    public boolean remove() {
        return false;
    }

    @Override
    public boolean print() {
        return appHelperUser.printList(repositoryUser.load());
    }

    @Override
    public Repository<User> getRepository() {
        return repositoryUser;
    }
}

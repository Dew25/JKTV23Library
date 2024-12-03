package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.interfaces.AppHelper;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.repository.AppRepository;
import ee.ivkhkdev.input.Input;
import ee.ivkhkdev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements AppService<User> {

    private  Input input;
    private  AppHelper<User> appHelperUser;
    private  UserRepository repositoryUser;

    @Autowired
    public UserService(Input input, AppHelper<User> appHelperUser, UserRepository repositoryUser) {
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


}

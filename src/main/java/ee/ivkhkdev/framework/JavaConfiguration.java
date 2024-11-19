package ee.ivkhkdev.framework;

import ee.ivkhkdev.App;
import ee.ivkhkdev.framework.config.Configuration;
import ee.ivkhkdev.helpers.*;
import ee.ivkhkdev.input.ConsoleInput;
import ee.ivkhkdev.input.Input;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.model.Register;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.repository.Repository;
import ee.ivkhkdev.repository.Storage;
import ee.ivkhkdev.services.*;

import java.util.HashMap;
import java.util.Map;

public class JavaConfiguration implements Configuration {
    private Map<String,Object> map;

    public JavaConfiguration() {
        init();
    }
    private void init(){
        Map<String,Object> map = new HashMap<>();
        map.put("input",new ConsoleInput());
        map.put("repositoryBook",new Storage<>("books"));
        map.put("repositoryAuthor",new Storage<>("authors"));
        map.put("repositoryUser",new Storage<>("users"));
        map.put("repositoryRegister", new Storage<>("registers"));
        map.put("appHelperAuthor",new AppHelperAuthor((Input) map.get("input")));
        map.put("appHelperUser",new AppHelperUser((Input) map.get("input")));
        map.put("userService", new UserService((Input) map.get("input"), (AppHelper<User>) map.get("appHelperUser"), (Repository<User>) map.get("repositoryUser")));
        map.put("appHelperBook", new AppHelperBook((Input) map.get("input"), (Service<Author>) map.get("authorService")));
        map.put("bookService", new BookService((Input) map.get("input"), (AppHelper<Book>) map.get("appHelperBook"), (Repository<Book>) map.get("repositoryBook"), (Service<Author>) map.get("authorService")));
        map.put("appHelperRegister",new AppHelperRegister((Input) map.get("input"), (Service<User>) map.get("userService"), (Service<Book>) map.get("bookService")));
        map.put("registerService", new RegisterService((AppHelper<Register>) map.get("appHelperRegister"),(Repository<Register>) map.get("repositoryRegister")));
        map.put("app",new App((Input) map.get("input"), (Service<Book>) map.get("authorService"), (Service<Author>) map.get("AuthorService"), (Service<User>) map.get("userService"), (Service<Register>) map.get("registerService")));
        this.map = map;
    }
    @Override
    public Object getObject(String name) {
        return this.map.get(name);
    }
}

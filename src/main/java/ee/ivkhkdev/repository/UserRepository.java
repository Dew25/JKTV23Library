package ee.ivkhkdev.repository;

import ee.ivkhkdev.interfaces.AppRepository;
import ee.ivkhkdev.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements AppRepository<User> {
    public String getFilename() {
        return "users";
    }
}

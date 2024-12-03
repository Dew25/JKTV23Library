package ee.ivkhkdev.repository;

import ee.ivkhkdev.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends AppRepository<User> {

    default public String getFilename() {
        return "users";
    }
}

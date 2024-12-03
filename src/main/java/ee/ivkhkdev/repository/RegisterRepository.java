package ee.ivkhkdev.repository;

import ee.ivkhkdev.model.Register;
import ee.ivkhkdev.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends AppRepository<Register> {

    default public String getFilename() {
        return "register";
    }
}

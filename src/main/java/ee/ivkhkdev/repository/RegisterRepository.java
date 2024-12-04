package ee.ivkhkdev.repository;

import ee.ivkhkdev.interfaces.AppRepository;
import ee.ivkhkdev.model.Register;
import org.springframework.stereotype.Repository;

@Repository
public class RegisterRepository implements AppRepository<Register> {

    public String getFilename() {
        return "register";
    }
}

package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.AppHelperRegisterInput;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.model.Register;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.repository.Repository;
import ee.ivkhkdev.interfaces.Input;

import java.util.List;

public class RegisterService {

    private final AppHelperRegisterInput appHelperRegisterInput;
    private final Repository repository;

    private final List<Register> registers;


    public RegisterService(List<Register> registers, Repository repository, AppHelperRegisterInput appHelperRegisterInput) {
        this.registers = registers;
        this.repository = repository;
        this.appHelperRegisterInput = appHelperRegisterInput;
    }

    public boolean bookBorrow() {
        Register register = appHelperRegisterInput.bookBorrow();
        if(register != null) {
            registers.add(register);
            repository.save(registers);
            return true;
        }else{
            return false;
        }
    }

    public boolean returnBook() {
        return appHelperRegisterInput.returnBookDialog();
    }
}

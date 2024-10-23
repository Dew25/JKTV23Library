package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.AppHelper;
import ee.ivkhkdev.helpers.AppHelperRegister;
import ee.ivkhkdev.model.Register;
import ee.ivkhkdev.repository.Repository;

import java.util.List;

public class RegisterService implements Service<Register>{

    private final AppHelper<Register> appHelperRegister;
    private final Repository repository;

    private final List<Register> registers;


    public RegisterService(List<Register> registers, Repository repository, AppHelper<Register> appHelperRegister) {
        this.registers = registers;
        this.repository = repository;
        this.appHelperRegister = appHelperRegister;
    }
    @Override
    public boolean add() {
        Register register = appHelperRegister.create();
        if(register != null) {
            registers.add(register);
            repository.save(registers);
            return true;
        }else{
            return false;
        }
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
    public void print() {
        appHelperRegister.printList();
    }

    @Override
    public Repository<Register> getRepository() {
        return repository;
    }

    public boolean returnBook() {
        return ((AppHelperRegister) appHelperRegister).returnBookDialog();
    }
}

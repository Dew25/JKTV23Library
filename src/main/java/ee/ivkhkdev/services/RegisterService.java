package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.AppHelper;
import ee.ivkhkdev.helpers.AppHelperRegister;
import ee.ivkhkdev.model.Register;
import ee.ivkhkdev.repository.Repository;

import java.util.List;

public class RegisterService implements Service<Register>{

    private final AppHelper<Register> appHelperRegister;
    private final Repository<Register> repositoryRegister;


    public RegisterService(AppHelper<Register> appHelperRegister,Repository<Register> repositoryRegister) {
        this.appHelperRegister = appHelperRegister;
        this.repositoryRegister=repositoryRegister;
    }
    @Override
    public boolean add() {
        Register register = appHelperRegister.create();
        if(register != null) {
            repositoryRegister.save(register);
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
    public boolean print() {
        return appHelperRegister.printList(getRepository().load());
    }

    @Override
    public Repository<Register> getRepository() {
        return repositoryRegister;
    }

    public boolean returnBook() {
        List<Register> registerList = ((AppHelperRegister) appHelperRegister).returnBookDialog(getRepository().load());
        if(registerList == null) {
            return false;
        }
        getRepository().saveAll(registerList);
        return true;

    }
}

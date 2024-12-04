package ee.ivkhkdev.services;


import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.interfaces.AppHelperRegister;
import ee.ivkhkdev.interfaces.AppRepository;
import ee.ivkhkdev.model.Register;
import ee.ivkhkdev.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RegisterService implements AppService<Register> {
    @Autowired
    private AppHelperRegister appHelperRegister;
    @Autowired
    private AppRepository<Register> repositoryRegister;

    @Autowired
    public RegisterService(AppHelperRegister appHelperRegister, RegisterRepository repositoryRegister) {
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
        return appHelperRegister.printList(repositoryRegister.load());
    }

    public boolean returnBook() {
        List<Register> registerList = appHelperRegister.returnBookDialog(repositoryRegister.load());
        if(registerList == null) {
            return false;
        }
        repositoryRegister.saveAll(registerList);
        return true;

    }
}

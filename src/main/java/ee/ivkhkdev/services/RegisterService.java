package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.AppHelperRegisterImpl;
import ee.ivkhkdev.helpers.interfaces.AppHelper;
import ee.ivkhkdev.model.Register;
import ee.ivkhkdev.repository.AppRepository;
import ee.ivkhkdev.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RegisterService implements AppService<Register> {

    private  AppHelper<Register> appHelperRegister;
    private  RegisterRepository repositoryRegister;

    @Autowired
    public RegisterService(AppHelper<Register> appHelperRegister, RegisterRepository repositoryRegister) {
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
        List<Register> registerList = ((AppHelperRegisterImpl) appHelperRegister).returnBookDialog(repositoryRegister.load());
        if(registerList == null) {
            return false;
        }
        repositoryRegister.saveAll(registerList);
        return true;

    }
}

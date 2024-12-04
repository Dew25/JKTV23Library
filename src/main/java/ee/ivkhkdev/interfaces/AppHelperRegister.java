package ee.ivkhkdev.interfaces;

import ee.ivkhkdev.model.Register;

import java.util.List;

public interface AppHelperRegister extends AppHelper<Register> {
    List<Register> returnBookDialog(List<Register> registers);
}

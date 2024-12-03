package ee.ivkhkdev.services;

import ee.ivkhkdev.repository.AppRepository;

public interface AppService<T> {
    boolean add();
    boolean edit();
    boolean remove();
    boolean print();
//    AppRepository<T> getRepository();
}

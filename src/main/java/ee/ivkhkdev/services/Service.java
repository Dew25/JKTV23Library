package ee.ivkhkdev.services;

import ee.ivkhkdev.repository.Repository;

public interface Service<T> {
    boolean add();
    boolean edit();
    boolean remove();
    void print();
    Repository<T> getRepository();
}

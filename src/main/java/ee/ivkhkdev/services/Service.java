package ee.ivkhkdev.services;

import ee.ivkhkdev.repository.Repository;

public interface Service<T> {
    boolean add();
    boolean edit();
    boolean remove();
    boolean print();
    Repository<T> getRepository();
}

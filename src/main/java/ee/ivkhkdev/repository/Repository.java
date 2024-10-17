package ee.ivkhkdev.repository;

import ee.ivkhkdev.model.User;

import java.util.List;

public interface Repository<T> {
    void save(T entity);
    List<T> load();
    List<T> getEntities();
}

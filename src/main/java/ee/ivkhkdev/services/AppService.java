package ee.ivkhkdev.services;

public interface AppService<T> {
    boolean add();
    boolean edit();
    boolean remove();
    boolean print();
//    AppRepository<T> getRepository();
}

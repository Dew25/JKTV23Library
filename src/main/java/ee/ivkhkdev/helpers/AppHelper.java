package ee.ivkhkdev.helpers;

import java.util.List;

public interface AppHelper<T> {
    T create();
    void printList();
    List<T> getList();
}

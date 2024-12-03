package ee.ivkhkdev.helpers.interfaces;

import java.util.List;

public interface AppHelper<T> {
    T create();
    boolean printList(List<T>entities);
    List<T> editEntities(List<T> entities);
}

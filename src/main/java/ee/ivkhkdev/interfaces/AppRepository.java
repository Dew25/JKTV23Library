package ee.ivkhkdev.interfaces;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public interface AppRepository<T> {

    public String getFilename();

    default public void save(T entity) {
        List<T> entities = this.load();
        if(entities == null) {entities = new ArrayList<>();}
        entities.add(entity);
        this.saveAll(entities);
    }

    default public void saveAll(List<T> entities) {
        if(entities == null) {entities = new ArrayList<>();}
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(getFilename());
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(entities);
            objectOutputStream.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Нет такого файла: "+e.toString());
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: "+e.toString());
        }
    }


    default public List<T> load() {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(getFilename());
            objectInputStream = new ObjectInputStream(fileInputStream);
            return (List<T>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Нет такого файла: "+e.toString());
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: "+e.toString());
        } catch (ClassNotFoundException e) {
            System.out.println("Не найден класс: "+e.toString());
        }
        return new ArrayList<T>();
    }
}

package ee.ivkhkdev.storages;

import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.repository.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Storage<T> implements Repository<T> {

    private String fileName;

    public Storage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save(List<T> entities) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(fileName);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(entities);
            objectOutputStream.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Нет такого файла: "+e.toString());
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: "+e.toString());
        }
    }

    @Override
    public List<T> load() {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(fileName);
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

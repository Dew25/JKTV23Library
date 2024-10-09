package ee.ivkhkdev.storages;

import ee.ivkhkdev.App;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.repository.BookRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StorageBook implements BookRepository {

    @Override
    public void saveBook(Book book) {
        App.books.add(book);
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("books");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(App.books);
            objectOutputStream.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Нет такого файла: "+e.toString());
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: "+e.toString());
        }
    }

    @Override
    public List<Book> loadBooks() {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream("employee");
            objectInputStream = new ObjectInputStream(fileInputStream);
            return (List<Book>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Нет такого файла: "+e.toString());
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: "+e.toString());
        } catch (ClassNotFoundException e) {
            System.out.println("Не найден класс: "+e.toString());
        }
        return new ArrayList<>();
    }
}

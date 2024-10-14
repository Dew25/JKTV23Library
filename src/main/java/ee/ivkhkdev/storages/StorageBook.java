package ee.ivkhkdev.storages;

import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.repository.BookRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StorageBook implements BookRepository {

    public static List<Book> books;
    private String fileName = "books";


    public StorageBook() {

    }

    @Override
    public void saveBook(Book book) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(fileName);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(books);
            objectOutputStream.flush();
            books.add(book);
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
            fileInputStream = new FileInputStream(fileName);
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

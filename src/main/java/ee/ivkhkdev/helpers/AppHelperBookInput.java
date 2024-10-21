package ee.ivkhkdev.helpers;

import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.interfaces.Input;

import java.util.Arrays;
import java.util.List;

public class AppHelperBookInput {
    public Book createBook(Input input){
        try {
            System.out.println("===== Новая книга =====");
            Book book = new Book();
            System.out.println("Название книги: ");
            book.setTitle(input.nextLine());
            System.out.println("Авторы: ");
            System.out.print("Количество авторов в книге: ");
            int countAuthors = Integer.parseInt(input.nextLine());
            for (int i = 0; i < countAuthors; i++){
                Author author = new Author();
                System.out.printf("Автор %d:%n", i+1);
                System.out.print("Имя автора: ");
                author.setFirstname(input.nextLine());
                System.out.print("Фамилия автора: ");
                author.setLastname(input.nextLine());
                book.getAuthors().add(author);
            }
            System.out.print("Год публикации: ");
            book.setPublishedYear(Integer.parseInt(input.nextLine()));
            return book;
        }catch (Exception e){
            System.out.println("Error: "+e.toString());
            return null;
        }
    }

    public void printBooks(List<Book> books) {
        if (books.isEmpty()){
            System.out.println(" --- Список пуст --- ");
        } else {
            System.out.println(" --- Список книг --- ");
            for (int i = 0; i < books.size(); i++){
                System.out.printf("%d. %s. %s. %d%n",
                    i+1,
                    books.get(i).getTitle(),
                    Arrays.toString(books.get(i).getAuthors().toArray()),
                    books.get(i).getPublishedYear()
                );
            }
            System.out.println(" --- Конец списка --- ");
        }
    }
}

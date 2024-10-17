package ee.ivkhkdev.helpers;

import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.tools.Input;

public class AppHelperBookInput {
    public Book createBook(Input input){
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
    }
}

package ee.ivkhkdev.helpers;

import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.interfaces.Input;

import java.util.List;

public class AppHelperBook implements AppHelper<Book>{
    private final Input input;
    private final List<Book> books;
    private final AppHelper<Author> appHelperAuthor;

    public AppHelperBook(Input input, List<Book> books, AppHelper<Author> appHelperAuthor) {
        this.input = input;
        this.books = books;
        this.appHelperAuthor = appHelperAuthor;
    }

    @Override
    public Book create(){
        try {
            System.out.println("===== Новая книга =====");
            Book book = new Book();
            System.out.print("Название книги: ");
            book.setTitle(input.nextLine());
            System.out.println("Авторы: ");
            appHelperAuthor.printList();
            System.out.println("Добавить нового автора в список? (y/n): ");
            String choosingNewAuthor = input.nextLine();
            if(choosingNewAuthor.equals("y")){
                return null;
            }
            System.out.print("Количество авторов в книге: ");
            int countAuthors = Integer.parseInt(input.nextLine());
            for (int i = 0; i < countAuthors; i++){
                System.out.printf("Выберите номер автора из списка (автор %d из %d): ",i+1,countAuthors);
                int numberAuthorInList = Integer.parseInt(input.nextLine());
                book.getAuthors().add(appHelperAuthor.getList().get(numberAuthorInList-1));
            }
            System.out.print("Год публикации книги: ");
            book.setPublishedYear(Integer.parseInt(input.nextLine()));
            return book;
        }catch (Exception e){
            System.out.println("Error: "+e.toString());
            return null;
        }
    }

    @Override
    public void printList() {
        if (books.isEmpty()){
            System.out.println(" --- Список пуст --- ");
        } else {
            System.out.println(" --- Список книг --- ");
            for (int i = 0; i < books.size(); i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<books.get(i).getAuthors().size();j++){
                          sb.append(books.get(i).getAuthors().get(j).getFirstname())
                            .append(" ")
                            .append(books.get(i).getAuthors().get(j).getLastname())
                            .append(". ");
                }
                System.out.printf("%d. %s. %s%d%n",
                    i+1,
                    books.get(i).getTitle(),
                    sb.toString(),
                    books.get(i).getPublishedYear()
                );
            }
            System.out.println(" --- Конец списка --- ");
        }
    }

    @Override
    public List<Book> getList() {
        return books;
    }
}

package ee.ivkhkdev.helpers;

import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.input.Input;
import ee.ivkhkdev.services.Service;

import java.util.List;

public class AppHelperBook implements AppHelper<Book>{
    private final Input input;
    private final Service<Author> authorService;

    public AppHelperBook(Input input, Service<Author> authorService) {
        this.input = input;
        this.authorService = authorService;
    }

    @Override
    public Book create(){
        try {
            System.out.println("===== Новая книга =====");
            Book book = new Book();
            System.out.print("Название книги: ");
            book.setTitle(input.nextLine());
            System.out.println("Авторы: ");
            authorService.print();
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
                book.getAuthors().add(authorService.getRepository().load().get(numberAuthorInList-1));
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
    public boolean printList(List<Book> books) {
        if (books == null || books.isEmpty()){
            System.out.println(" --- Список пуст --- ");
            return false;
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
            return true;
        }
    }

    @Override
    public List<Book> editEntities(List<Book> entities) {
        return List.of();
    }


}

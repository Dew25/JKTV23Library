package ee.ivkhkdev.helpers;

import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.model.Author;

import java.util.List;

public class AppHelperAuthor implements AppHelper<Author>{
    private final Input input;
    private final List<Author> authors;

    public AppHelperAuthor(Input input, List<Author> authors) {
        this.input = input;
        this.authors = authors;
    }
    @Override
    public Author create(){
        try {
            System.out.println("===== Новый автор =====");
            Author author = new Author();
            System.out.print("Имя: ");
            author.setFirstname(input.nextLine());
            System.out.println("Фамилия: ");
            author.setLastname(input.nextLine());
            return author;
        }catch (Exception e){
            System.out.println("Error: "+e.toString());
            return null;
        }
    }
    @Override
    public void printList() {
        if (authors.isEmpty()){
            System.out.println(" --- Список пуст --- ");
        } else {
            System.out.println(" --- Список авторов --- ");
            for (int i = 0; i < authors.size(); i++){
                System.out.printf("%d. %s %s%n",
                    i+1,
                    authors.get(i).getFirstname(),
                    authors.get(i).getLastname()
                );
            }
            System.out.println(" --- Конец списка --- ");
        }
    }

    @Override
    public List<Author> getList() {
        return authors;
    }
}

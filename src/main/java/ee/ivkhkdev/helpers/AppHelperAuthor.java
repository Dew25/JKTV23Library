package ee.ivkhkdev.helpers;

import ee.ivkhkdev.input.Input;
import ee.ivkhkdev.model.Author;

import java.util.List;

public class AppHelperAuthor implements AppHelper<Author>{
    private final Input input;


    public AppHelperAuthor(Input input) {
        this.input = input;

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
    public boolean printList(List<Author> authors) {
        if (authors == null || authors.isEmpty()){
            System.out.println(" --- Список пуст --- ");
            return false;
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
            return true;
        }
    }

    @Override
    public List<Author> editEntities(List<Author> entities) {
        printList(entities);
        System.out.println("Bыберите номер автора для редактирования: ");
        int numberAuthor = Integer.parseInt(input.nextLine());
        System.out.println( "Имя автора: "+entities.get(numberAuthor - 1).getFirstname());
        System.out.println("Изменить (y/n): ");
        String changeFirstname = input.nextLine();
        if(changeFirstname.equals("y")){
            System.out.println("Новое имя автора: ");
            entities.get(numberAuthor - 1).setFirstname(input.nextLine());
        }
        System.out.println( "Фамилия автора: "+entities.get(numberAuthor - 1).getFirstname());
        System.out.println("Изменить (y/n): ");
        String changeLastname = input.nextLine();
        if(changeLastname.equals("y")){
            System.out.println("Новая фамилия автора: ");
            entities.get(numberAuthor - 1).setLastname(input.nextLine());
        }
        return entities;
    }

}

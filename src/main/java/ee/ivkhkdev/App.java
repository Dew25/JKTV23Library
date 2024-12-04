package ee.ivkhkdev;

import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.model.Register;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.services.*;
import ee.ivkhkdev.input.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired private  Input input;
    @Autowired private  AppService<Author> authorService;
    @Autowired private  AppService<Book> bookService;
    @Autowired private  AppService<User> userService;
    @Autowired private  AppService<Register> registerService;



    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }

     @Override
     public void run(String... args) throws Exception {
        boolean repeat = true;
        System.out.println("--------------- JKTV23 библиотека --------------");
        do {
            System.out.println("Список задач: ");
            System.out.println("0. Выход из программы");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Добавить читателя");
            System.out.println("3. Список книг");
            System.out.println("4. Список читателей");
            System.out.println("5. Выдать книгу");
            System.out.println("6. Вернуть книгу");
            System.out.println("7. Добавить автора");
            System.out.print("Выберите номер задачи из списка: ");
            int task = Integer.parseInt(input.nextLine());
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    if(bookService.add()){
                        System.out.println("Книга добавлена");
                    } else {
                        System.out.println("Книгу добавить не удалось");
                    }
                    break;
                case 2:
                    if(userService.add()){
                        System.out.println("Читатель добавлен");
                    } else {
                        System.out.println("Читателя добавить не удалось");
                    }
                    break;
                case 3:
                    bookService.print();
                    break;
                case 4:
                    userService.print();
                    break;
                case 5:
                    if (registerService.add()) {
                        System.out.println("Книга выдана");
                    } else {
                        System.out.println("Книгу выдать не удалось");
                    }
                    break;
                case 6:
                    if (((RegisterService)registerService).returnBook()) {
                        System.out.println("Книга возвращена");
                    }else{
                        System.out.println("Книгу вернуть не удалось");
                    }
                    break;
                case 7:
                    if(authorService.add()){
                        System.out.println("Автор добавлен");
                    }else{
                        System.out.println("Автора добавить не удалось");
                    }
                    break;
                default:
                    System.out.println("Выберите номер задачи из списка!");
            }
        }while (repeat);
        System.out.println("До свидания!");

    }


}

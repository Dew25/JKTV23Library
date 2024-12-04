package ee.ivkhkdev.services;

import ee.ivkhkdev.interfaces.AppHelperBook;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.input.Input;
import ee.ivkhkdev.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService implements AppService<Book>{

    private  Input input;
    private AppHelperBook appHelperBook;
    private  BookRepository repositoryBook;
    private  AppService<Author> authorService;

    @Autowired
    public BookService(Input input, AppHelperBook appHelperBook, BookRepository repositoryBook, AppService<Author> authorService) {
        this.input = input;
        this.repositoryBook = repositoryBook;
        this.appHelperBook = appHelperBook;
        this.authorService = authorService;

    }
    @Override
    public boolean add(){
        Book book = appHelperBook.create();
        if(book != null) {
            repositoryBook.save(book);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean edit() {
        return false;
    }

    @Override
    public boolean remove() {
        return false;
    }
    @Override
    public boolean print() {
        return  appHelperBook.printList(this.repositoryBook.load());
    }

}

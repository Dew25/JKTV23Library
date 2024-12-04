package ee.ivkhkdev.services;

import ee.ivkhkdev.interfaces.AppHelperAuthor;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService implements AppService<Author> {

    @Autowired
    private AppHelperAuthor appHelperAuthor;
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public boolean add(){
        Author author = appHelperAuthor.create();
        if(author != null) {
            authorRepository.save(author);
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
        return appHelperAuthor.printList(authorRepository.load());
    }

}

package dh.meli.relationships.service;

import dh.meli.relationships.model.Author;
import dh.meli.relationships.repository.IAuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AuthorService {

    @Autowired
    private IAuthorRepo repo;

    @Transactional // se der ruim, faz rollback
    public Author save(Author author) {
        author.getAddress().setAuthor(author);
        return repo.save(author);
    }
}

package dh.meli.relationships.repository;

import dh.meli.relationships.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepo extends CrudRepository<Book, Long> {

}

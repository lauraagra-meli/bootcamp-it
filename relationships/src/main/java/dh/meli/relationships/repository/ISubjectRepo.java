package dh.meli.relationships.repository;

import dh.meli.relationships.model.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubjectRepo extends CrudRepository<Subject, Long> {

}

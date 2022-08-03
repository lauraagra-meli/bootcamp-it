package dh.meli.reviewtests.repository;

import dh.meli.reviewtests.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> { // o JPA é um extends do crud, mas adiciona algumas outras funcionalidades (como listas)

}

package br.dh.meli.sprintdata01.repository;

import br.dh.meli.sprintdata01.model.UserBD;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// não precisa implementar a interface na classe, entao nao existe uma classe que implementa a interface
// o JPA que faz isso
@Repository
public interface IUserDbRepo extends CrudRepository<UserBD, Long> { // extendendo de uma classe que ja declara as funcoes do crud
    UserBD findByEmail(String email); // na documentacao do JPA tem varios metodos predefinidos com nomes definidos, um exemplo disso é o findByEmail
    // UserBD findByNameOrEmail(String email);
}

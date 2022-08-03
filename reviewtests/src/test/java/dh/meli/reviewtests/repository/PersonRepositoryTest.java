package dh.meli.reviewtests.repository;

import dh.meli.reviewtests.model.Person;
import dh.meli.reviewtests.util.GeneratePerson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository repository;

    @Test
    public void save_returnSavedPerson_whenValidPerson() {
        Person person = GeneratePerson.newPerson1ToSave(); // ter uma pessoa pronta pra fazer a gravacao

        // acao
        Person personSaved = repository.save(person); // execucao

        // ver se o que eu fiz deu certo
        // ver se o que eu salvei é o que ta no banco
        assertThat(personSaved.getName()).isEqualTo(person.getName()); // testando o nome
    }

}

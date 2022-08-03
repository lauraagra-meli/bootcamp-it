package dh.meli.reviewtests.service;

import dh.meli.reviewtests.exception.InvalidPersonParam;
import dh.meli.reviewtests.model.Person;
import dh.meli.reviewtests.repository.PersonRepository;
import dh.meli.reviewtests.util.GeneratePerson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @InjectMocks
    private PersonService personService; // recebe a injecao de dependencia que sera o mock (isso porque na classe do service tem uma dependencia do repository e aqui como queremos testar unitariamente, precisamos simular a injecao com o mockito)

    // criando um mock que sera injetado dentro do service
    @Mock
    private PersonRepository personRepository; // pro service nao depender do repository, usamos mockito

    @Test
    public void save_savePerson_whenValidPerson() {
        // definir o comportamento do repo quando aciona-lo
        BDDMockito.when(personRepository.save(ArgumentMatchers.any(Person.class))) // qualquer objeto do tipo person
                .thenReturn(GeneratePerson.validPerson1());

        // nao vai chamar o metodo real, vai chamar a linha acima (service chama o save do repository)
        Person person = GeneratePerson.newPerson1ToSave();

        Person personSaved = personService.save(person); // acao a ser testada

        assertThat(personSaved).isNotNull(); // nao pode retornar nulo
        assertThat(personSaved.getId()).isPositive(); // se o id é um numero positivo
        assertThat(personSaved.getName()).isEqualTo(person.getName()); // se é o mesmo nome salvo

        //quando o metodo nao retorne nada testa o efeito colateral
        verify(personRepository, Mockito.only()).save(person); // quantas vezes o metodo tem que ser chamado
    }

    @Test
    public void save_throwException_whenPersonHasId() { // nao pode gravar porque precisaria atualizar
        // nao vai chamar o metodo real, vai chamar a linha acima (service chama o save do repository)
        Person person = GeneratePerson.newPerson1ToSave();

        assertThrows(InvalidPersonParam.class, () -> {
            Person personSaved = personService.save(person); // precisa envolver a chamada dentro de um tratamento de excecao
        }); // qual tipo de excecao e qual a acao

        //quando o metodo nao retorne nada testa o efeito colateral
        verify(personRepository, Mockito.never()).save(person); // quantas vezes o metodo tem que ser chamado (nesse casa nunca, porque a excecap tem que pegar o problema antes)
    }
}

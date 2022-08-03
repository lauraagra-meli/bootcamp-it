package dh.meli.reviewtests.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import dh.meli.reviewtests.model.Person;
import dh.meli.reviewtests.repository.PersonRepository;
import dh.meli.reviewtests.util.GeneratePerson;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// para os testes de integracao precisa trocar o profile pra dev (seria tipo um espelho de prod)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // qualquer porta que esteja livre
@AutoConfigureMockMvc // fazer configuracoes padrao
public class PersonControllerITTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ObjectMapper objectMapper; // json

    @BeforeEach
    public void setup() {
        personRepository.deleteAll(); // antes de cada teste quer que zere o banco la no repo
    }

    @Test // copiou o metodo do teste unitario do controller e retirou apenas o mock
    public void create_insertNewPerson_whenNewPerson() throws Exception {
        Person person = GeneratePerson.newPerson1ToSave();

        ResultActions response = mockMvc.perform(post("/person") // acionar atraves do metodo post
                .content(objectMapper.writeValueAsString(person))
                .contentType(MediaType.APPLICATION_JSON)
        );

        response.andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", CoreMatchers.is(person.getName()))); // o que do json eu quero pegar ($ representa a raiz)
    }

}

package dh.meli.reviewtests.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dh.meli.reviewtests.model.Person;
import dh.meli.reviewtests.service.PersonService;
import dh.meli.reviewtests.util.GeneratePerson;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PersonController.class)
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc; // simular o processo http (nao precisa subir o servidor)

    @Autowired
    private ObjectMapper objectMapper; // Json para String

    @MockBean
    private PersonService service;

    @Test
    public void create_insertNewPerson_whenNewPerson() throws Exception {
        BDDMockito.given(service.save(ArgumentMatchers.any(Person.class)))
                .willAnswer((invocation) -> invocation.getArgument(0)); // testando comportamento do controller independente do retorno

        Person person = GeneratePerson.newPerson1ToSave();

        ResultActions response = mockMvc.perform(post("/person") // acionar atraves do metodo post
                .content(objectMapper.writeValueAsString(person))
                .contentType(MediaType.APPLICATION_JSON)
        );

        response.andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", CoreMatchers.is(person.getName()))); // o que do json eu quero pegar ($ representa a raiz)
    }
}

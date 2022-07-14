package com.meli.obterdiploma.integration;

import com.meli.obterdiploma.model.StudentDTO;
import com.meli.obterdiploma.repository.StudentDAO;
import com.meli.obterdiploma.util.TestUtilsGenerator;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2 // gera um objeto do tipo log - tipo sout
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // subir numa porta qualquer (encontre uma porta disponivel e escolha ela)
public class StudentIntegration {

    @LocalServerPort // define a porta, preenche o valor da variavel com a porta encontrada
    private int port;

    @Autowired // precisa dele pra fazer as chamadas
    TestRestTemplate testRestTemplate; // permite fazer requisicoes quando o cliente vai fazer chamada cliente servidor - classe especifica usada pra fazer teste

    // antes de cada teste
    @BeforeEach
    public void setup() {
        // limpa o arquivo
        TestUtilsGenerator.emptyUsersFile();
    }

    @Test
    @DisplayName("Inserting a new student")
    public void registerStudent_saveStudent_whenNewStudent() {
        StudentDTO newStudent = TestUtilsGenerator.getNewStudentWithOneSubject();
        String baseUrl = "http://localhost:" + port + "/student"; // pra montar a url + a porta definida la em cima + a rota
        HttpEntity<StudentDTO> httpEntity = new HttpEntity<>(newStudent);

        // espera como resposta um response e dentro do response tem o objeto
        // exchange(URL, metodo http, body (o que to mandando), tipo de objeto no retorno)
        ResponseEntity<StudentDTO> response = testRestTemplate.exchange(baseUrl + "/registerStudent"
                , HttpMethod.POST
                , httpEntity
                , StudentDTO.class); // o .class é usado quando pede o tipo de classe

        StudentDTO studentResponse = response.getBody(); // retorna o conteudo do body

        // trabalhar em cima do response pra fazer as validacoes
        // preciso saber o que espero encontrar
        // pra rodar o teste a primeira vez, precisa que o banco esteja zerado
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(studentResponse).isNotNull();
        assertThat(studentResponse.getId()).isPositive(); // se é um numero que existe
        assertThat(studentResponse.getStudentName()).isEqualTo(newStudent.getStudentName()); // se o nome é o mesmo que retornou
    }

    @Test
    @DisplayName("Create student with Id")
    public void registerStudent_returnBadRequest_whenStudentHasId() {
        StudentDTO newStudent = TestUtilsGenerator.getStudentWithId();
        String baseUrl = "http://localhost:" + port + "/student"; // pra montar a url + a porta definida la em cima + a rota
        HttpEntity<StudentDTO> httpEntity = new HttpEntity<>(newStudent);

        // espera como resposta um response e dentro do response tem o objeto
        // exchange(URL, metodo http, body (o que to mandando), tipo de objeto no retorno)
        ResponseEntity<StudentDTO> response = testRestTemplate.exchange(baseUrl + "/registerStudent"
                , HttpMethod.POST
                , httpEntity
                , StudentDTO.class); // o .class é usado quando pede o tipo de classe

        // trabalhar em cima do response pra fazer as validacoes
        // preciso saber o que espero encontrar
        // pra rodar o teste a primeira vez, precisa que o banco esteja zerado
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    @DisplayName("get student")
    public void getStudent_returnStatusNotFound_whenStudentNotExist() {
        StudentDTO student = TestUtilsGenerator.getStudentWithId();
        String baseUrl = "http://localhost:" + port + "/student"; // pra montar a url + a porta definida la em cima + a rota

        // exchange(URL, metodo http, body (o que to mandando), tipo de objeto no retorno)
        ResponseEntity<StudentDTO> response = testRestTemplate.exchange(baseUrl + "/getStudent/" + student.getId()
                , HttpMethod.GET
                , null // nao manda um corpo - referencia ao que esta no body
                , StudentDTO.class); // o .class é usado quando pede o tipo de classe

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    @DisplayName("get student")
    public void getStudent_returnStudent_whenStudentExist() {
        StudentDTO newStudent = TestUtilsGenerator.getNewStudentWithOneSubject();
        String baseUrl = "http://localhost:" + port + "/student/getStudent"; // pra montar a url + a porta definida la em cima + a rota
        StudentDAO dao = new StudentDAO();
        StudentDTO studentSaved = dao.save(newStudent);

        // format gera uma nova string a partir de uma string colocada, o %d converte o valor
        String url = String.format(baseUrl + "%d", studentSaved.getId());

        // exchange(URL, metodo http, body (o que to mandando), tipo de objeto no retorno)
        ResponseEntity<StudentDTO> response = testRestTemplate.exchange(url
                , HttpMethod.GET
                , null // nao manda um corpo - referencia ao que esta no body
                , StudentDTO.class); // o .class é usado quando pede o tipo de classe

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getId()).isEqualTo(studentSaved.getId()); // o id que mandei salvar tem que ser o que ele encontrou
        assertThat(response.getBody().getStudentName()).isEqualTo(studentSaved.getStudentName());
    }

    @Test
    @DisplayName("modify student")
    public void modifyStudent_returnStatusNoContent_whenStudentExist() {
        String baseUrl = "http://localhost:" + port + "/student/modifyStudent"; // pra montar a url + a porta definida la em cima + a rota

        StudentDTO newStudent = TestUtilsGenerator.getNewStudentWithOneSubject(); // gerar novo estudante
        StudentDAO dao = new StudentDAO();
        StudentDTO studentSaved = dao.save(newStudent);

        studentSaved.setStudentName("New name");
        HttpEntity<StudentDTO> httpEntity = new HttpEntity<>(studentSaved);

        // exchange(URL, metodo http, body (o que to mandando), tipo de objeto no retorno)
        ResponseEntity<Void> response = testRestTemplate.exchange(baseUrl
                , HttpMethod.PUT
                , httpEntity // nao manda um corpo - referencia ao que esta no body
                , Void.class); // o .class é usado quando pede o tipo de classe

        // verificando se o retorno bate com o que é esperado
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);

        // la no banco bate com o que eu espero
        StudentDTO studentFound = dao.findById(studentSaved.getId());
        assertThat(studentFound.getStudentName()).isEqualTo(studentSaved.getStudentName());
    }
}

package com.meli.obterdiploma.service;

import com.meli.obterdiploma.model.StudentDTO;
import com.meli.obterdiploma.repository.IStudentDAO;
import com.meli.obterdiploma.util.TestUtilsGenerator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

// COMO VAMOS USAR UM MOCK É NECESSÁRIO ANOTAR O AMBIENTE QUE SERÁ USADO PARA RODAR ESSA CLASSE DE TESTE AQUI
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT) // se sobrar informacao, nao notificar
class StudentServiceTest {

    // VOU TESTAR A CLASSE STUDENT SERVICE
    // QUANDO PEDIR PARA GERAR O STUDENT SERVICE É NECESSARIO INFORMAR QUE TEREMOS MOCKS. GERA UM OBJETO PARA
    // SER CONSUMINDO DENTRO DO TESTE E AS DEPENDÊNCIAS DELE SERÃO GERADAS VIA MOCK
    @InjectMocks
    StudentService service;

    // INFORMO QUE ESSA IMPLEMENTAÇÃO É QUE SERÁ MOCKADA
    @Mock
    IStudentDAO studentDAO;

    @BeforeEach
    public void setup() {
        //create
        // QUANDO CHAMAR O MÉTODO SAVE, DEVE CHAMAR ESSE MOCK
        // QUANDO CHAMAR O MÉTODO SAVE COM QUALQUER ARGUMENTO DA STUDENT DTO
        // chamamos o bddmockito pra configurar no nosso ambiente que, sempre que ele bater em uma instancia da StudentDTO ele desvia o comportamento pro helper do test
        // quando for chamado o metodo save com algum argumento que seja estudante
        BDDMockito.when(studentDAO.save(ArgumentMatchers.any(StudentDTO.class)))
                .thenReturn(TestUtilsGenerator.getStudentWithId()); // quando acontecer isso... então...
        // retornar o estudante com ID

        // read
        BDDMockito.when(studentDAO.findById(ArgumentMatchers.anyLong()))
                .thenReturn(TestUtilsGenerator.getStudentWithId());
        // QUANDO CHAMAR O FIDBYIDCOM QQ ID, RETORNA UM ESTUDANTE (OBJETO) COM ID

        // delete - nao retorna nada
        BDDMockito.doNothing().when(studentDAO).delete(ArgumentMatchers.anyLong());
        // NAO FAÇA NADA QUANDO STUDENT DAO EXECUTA DELETE COM QQ ARGUMENTO
    }

    @Test
    void create_returnStudent_whenNewStudent() {
        // GERA NOVO ESTUDANTE
        StudentDTO newStudent = TestUtilsGenerator.getNewStudentWithOneSubject();
        // O savedStudent é o mockado no setup
        StudentDTO savedStudent = service.create(newStudent);

        // SE NÃO SALVOU NO BANCO COMO QUE VAI TESTAR?
        // ASSIM:
        assertThat(savedStudent.getId()).isPositive();
        assertThat(savedStudent.getStudentName()).isEqualTo(savedStudent.getStudentName());
        // TESTAR SE O MÉTODO FOI CHAMADO. alLeastOnce SIGNIFICA SE FOI CHAMADO UMA VEZ. O verify() é do bdd mockito
        verify(studentDAO, atLeastOnce()).save(newStudent);

    }


    @Test
    void read_returnStudent_whenStudentExist() {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId();
        StudentDTO studentFound = service.read(studentDTO.getId());

        assertThat(studentFound.getId()).isEqualTo(studentDTO.getId());
        verify(studentDAO, atLeastOnce()).findById(studentDTO.getId()); // verificar quantas vezes o metodo foi chamado
    }

    @Test
    void update_updateStudent_whenStudentExist() {
        StudentDTO newStudent = TestUtilsGenerator.getStudentWithId();
        service.update(newStudent);

        assertThat(newStudent.getId()).isEqualTo(newStudent.getId());
        verify(studentDAO, atLeastOnce()).save(newStudent);
    }

    @Test
    void delete_deleteStudent_whenStudentExist() {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId();

        // VERIFICAR QUE A CHAMADA
        assertThatCode(() -> {
            // DO MÉTODO DELETE
            service.delete(studentDTO.getId());
            // NÃO DISPARA UMA EXCEÇÃO
        }).doesNotThrowAnyException(); // ao chamar a execucao da funcao, nao dispara nenhuma excecao

        verify(studentDAO, atLeastOnce()).delete(studentDTO.getId());
    }

    @Test
    void getAll() {
    }
}
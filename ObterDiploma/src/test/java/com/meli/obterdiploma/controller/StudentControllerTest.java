package com.meli.obterdiploma.controller;

import com.meli.obterdiploma.model.StudentDTO;
import com.meli.obterdiploma.service.IStudentService;
import com.meli.obterdiploma.util.TestUtilsGenerator;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

// @SpringBootTest // sobe a aplicação
// COMO VAMOS USAR UM MOCK É NECESSÁRIO ANOTAR O AMBIENTE QUE SERÁ USADO PARA RODAR ESSA CLASSE DE TESTE AQUI
@ExtendWith(MockitoExtension.class)
// DESLIGA AS VALIDAÇÕES
@MockitoSettings(strictness = Strictness.LENIENT)
class StudentControllerTest {

    @InjectMocks
    private StudentController controller;

    @Mock
    IStudentService studentService;

    @BeforeEach
    void setup() {
        // OS MOCKS SÃO NECESSÁRIOS, PARA EVITAR A DEPENDÊNCIA DESTA CAMADA COM A CAMANDA ANTERIOR
        // A CAMADA REPOSITORY NÃO PRECISOU DE MOCK, JUSTAMENTE POR ELA SER A PRIMEIRA

        BDDMockito.when(studentService.create(ArgumentMatchers.any(StudentDTO.class)))
                .thenReturn(TestUtilsGenerator.getStudentWithId());

        BDDMockito.when(studentService.read(ArgumentMatchers.anyLong()))
                .thenReturn(TestUtilsGenerator.getStudentWithId());

        BDDMockito.doNothing().when(studentService).delete(ArgumentMatchers.anyLong());

        // NÃO FAÇA NADA QUANDO STUDENT SERVICE EXECUTAR O DELETE COM QQ ARGUMENTO
        BDDMockito.doNothing().when(studentService).update(ArgumentMatchers.any(StudentDTO.class));
    }

    @Test
    void registerStudent() {
        StudentDTO newStudent = TestUtilsGenerator.getNewStudentWithOneSubject();

        ResponseEntity<StudentDTO> response = controller.registerStudent(newStudent);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull(); // pode encadear varias coisas
        assertThat(response.getBody().getId())
                .isNotNull()
                .isPositive(); // pode encadear varias coisas

        verify(studentService, atLeastOnce()).create(newStudent);
    }

    @Test
    void getStudent() {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId();

        // AO CHAMAR O CONTROLLER, ELE CHAMA O MÉTODO MOCK, E TEM COMO RESPOSTA UM STUDENT COM ID
        ResponseEntity<StudentDTO> response = controller.getStudent(studentDTO.getId());

        verify(studentService, atLeastOnce()).read(studentDTO.getId());
        // VERIFICA SE TEM O MESMO ID
        assertThat(response.getBody().getId()).isEqualTo(studentDTO.getId());
    }

    @Test
    void removeStudent() {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId();
        ResponseEntity<Void> response = controller.removeStudent(studentDTO.getId());

        // VALIDA SE O MÉTODO FOI CHAMADO 1 VEZ
        verify(studentService, atLeastOnce()).delete(studentDTO.getId());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

//    @Test
//    void modifyStudent() {
//        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId();
//        ResponseEntity<Void> response = controller.modifyStudent(studentDTO);
//
//        verify(studentService, atLeastOnce()).update(studentDTO);
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//    }

//    @Test
//    void listStudents() {
//
//    }
}
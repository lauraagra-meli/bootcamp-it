package com.meli.obterdiploma.repository;

import com.meli.obterdiploma.exception.StudentNotFoundException;
import com.meli.obterdiploma.model.StudentDTO;
import com.meli.obterdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.*;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

class StudentDAOTest {

    /* GERA OBJETO, SÓ QUE PRECISO ABSTRAIR ESSA RESPONSBILIDADE
    private StudentDAO studentDAO = new StudentDAO();
    */

    /* INJEÇÃO DE INDEPENDÊNCIA DO SPRING.
     SIGNIFICA QUE O SPRING GERA O OBJETO QUE PODERÁ SER USADO.
     O SPRING BUSCA UM OBJETO QUE ELE VAI INSTANCIAR, ATRAVÉS DA IMPLEMENTAÇÃO DA INTERFACE.
     ESSA IMPLEMENTAÇÃO É A StudentDAO.
     O PROCESSO DE INJEÇÃO DE DEPENDÊNCIA É PASSAR UMA INTERFACE PARA O SPRING E ELE PROCURA A IMPLEMENTAÇÃO DELA
     PARA USAR. COMO SÓ EXISTE 1 CLASSE IMPLEMENTANDO ESSA INTERFACE, ELE SABERÁ QUAL USAR.
     NESTE EXEMPLO, FOI REMOVIDA A INJEÇÃO DE DEPENDÊNCIA ABAIXO, PARA UTILIZAR O MÉTODO setup()
     Porque: O OBJETO DO STUDENTDAO DEVE SER GERADO A CADA VEZ QUE FOR RODAR OS TESTES
     @Autowired
     private IStudentDAO studentDAO;
    */

    private String SCOPE;
    //private Set<StudentDTO> students;
    private IStudentDAO studentDAO;

    // pra zerar o arquivo de dados ANTES DE CADA TESTE
    @BeforeEach
    void setup() {
        // APAGAR OS DADOS QUE ESTÃO NO ARQUIVO
        TestUtilsGenerator.emptyUsersFile();
        // GERAR O OBJETO
        studentDAO = new StudentDAO();
    }

    // DEPOIS DE TESTAR TUDO.
    // @AfterAll
    // Tem que ser um método estático
    // Foi removido, conforme o do professor, porque apareceram comportamentos indesejados, que não serão sanados porque são irrelevantes, pois possivelmente são compartamentos por estar usando um arquivo para salvar
    // public static void tearDown() {
    // APAGAR OS DADOS QUE ESTÃO NO ARQUIVO
    // TestUtilsGenerator.emptyUsersFile();
    // }

    @Test
    void save_saveStudent_whenNewStudent() {
        StudentDTO newStudent = TestUtilsGenerator.getNewStudentWithOneSubject();
        StudentDTO savedStudent = studentDAO.save(newStudent);

        assertThat(savedStudent).isNotNull();
        assertThat(savedStudent.getId().doubleValue()).isPositive();
        assertThat(savedStudent.getStudentName()).isEqualTo(newStudent.getStudentName());

    }

    @Test
    void save_saveStudent_whenStudentWithId() {
        StudentDTO newStudent = TestUtilsGenerator.getNewStudentWithOneSubject();
        StudentDTO savedStudent = studentDAO.save(newStudent);

        savedStudent.setStudentName("New name");
        savedStudent.getSubjects().get(0).setName("New subject");

        StudentDTO updatedStudent = studentDAO.save(savedStudent);

        assertThat(updatedStudent).isNotNull();
        assertThat(updatedStudent.getId()).isEqualTo(savedStudent.getId());
        assertThat(updatedStudent.getStudentName()).isEqualTo(savedStudent.getStudentName());
        assertThat(updatedStudent.getSubjects().get(0).getName())
                .isEqualTo(savedStudent.getSubjects().get(0).getName());
    }

    @Test
    void save_throwException_whenStudentWithIdAndNotExist() {
        StudentDTO student = TestUtilsGenerator.getStudentWithId();

        StudentNotFoundException exception = Assertions.assertThrows(StudentNotFoundException.class, () -> { // que tipo de excecao vai acontecer e acao que vai fazer
            StudentDTO savedStudent = studentDAO.save(student);
        });

        assertThat(exception.getError().getDescription()).contains(student.getId().toString());
        assertThat(exception.getStatus()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    // testando quando um método não tem retornon (void)
    @Test
    void delete_removeStudent_whenStudentExist() {
        StudentDTO newStudent = TestUtilsGenerator.getNewStudentWithOneSubject(); // criando novo estudante
        StudentDTO savedStudent = studentDAO.save(newStudent); // salvando no banco

        studentDAO.delete(savedStudent.getId()); // deletando o que acabou de salvar
//        boolean found = studentDAO.exists(savedStudent); // se o cara realmente foi deletado

        assertThat(studentDAO.exists(savedStudent)).isFalse(); // como o estudante não existe, precisa ser falso
    }

    @Test
    void delete_throwException_whenStudentNotExist() {
        StudentDTO student = TestUtilsGenerator.getStudentWithId();

        // testando algo que lança excecao
        StudentNotFoundException exception = Assertions.assertThrows(StudentNotFoundException.class, () -> { // que tipo de excecao vai acontecer e acao que vai fazer
            studentDAO.delete((student.getId()));
        });

        assertThat(exception.getError().getDescription()).contains(student.getId().toString());
        assertThat(exception.getStatus()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void exists_returnTrue_whenStudentExist() {
        StudentDTO newStudent = TestUtilsGenerator.getNewStudentWithOneSubject();
        StudentDTO savedStudent = studentDAO.save(newStudent);

        boolean found = studentDAO.exists(savedStudent);

        assertThat(found).isTrue();
    }

    @Test
    void exists_returnFalse_whenStudentNotExist() {
        StudentDTO student = TestUtilsGenerator.getNewStudentWithOneSubject();

        boolean found = studentDAO.exists(student);

        assertThat(found).isFalse();
    }

    @Test
    void findById_returnStudent_whenStudentExist() {
        StudentDTO newStudent = TestUtilsGenerator.getNewStudentWithOneSubject();
        StudentDTO savedStudent = studentDAO.save(newStudent);

        StudentDTO foundStudent = studentDAO.findById(savedStudent.getId());

        assertThat(foundStudent).isNotNull();
        assertThat(foundStudent.getId()).isEqualTo(savedStudent.getId());
        assertThat(foundStudent.getStudentName()).isEqualTo(savedStudent.getStudentName());
    }

    @Test
    void findById_returnStudent_whenStudentNotExist() {
        StudentDTO student = TestUtilsGenerator.getStudentWithId();

        // testando algo que lança excecao
        StudentNotFoundException exception = Assertions.assertThrows(StudentNotFoundException.class, () -> { // que tipo de excecao vai acontecer e acao que vai fazer
            StudentDTO foundStudent = studentDAO.findById(student.getId());
        });

        assertThat(exception.getError().getDescription()).contains(student.getId().toString());
        assertThat(exception.getStatus()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
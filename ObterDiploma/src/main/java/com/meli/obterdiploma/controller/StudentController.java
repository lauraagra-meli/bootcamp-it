package com.meli.obterdiploma.controller;

import com.meli.obterdiploma.model.StudentDTO;
import com.meli.obterdiploma.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @PostMapping("/registerStudent")
    public ResponseEntity<StudentDTO> registerStudent(@RequestBody @Valid StudentDTO stu) {
        // se na hora de registrar o estudante o id ja existir, ta errado
        if (stu.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.create(stu));
    }

    @GetMapping("/getStudent/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.read(id)); // retorna ok se achar o estudanco cujo id passei como parametro
    }

    @PutMapping("/modifyStudent")
    public ResponseEntity<Void> modifyStudent(@RequestBody @Valid StudentDTO stu) {
        this.studentService.update(stu);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/removeStudent/{id}")
    public ResponseEntity<Void> removeStudent(@PathVariable Long id) {
        this.studentService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/listStudents")
    public Set<StudentDTO> listStudents() {
        return this.studentService.getAll();
    }

}

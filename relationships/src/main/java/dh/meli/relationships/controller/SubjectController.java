package dh.meli.relationships.controller;

import dh.meli.relationships.model.Subject;
import dh.meli.relationships.repository.ISubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private ISubjectRepo repo; // nao é recomendado injetar o repo direto no controller, foi so pra ganhar tempo e nao criar a camada service

    @GetMapping("/{id}")
    public ResponseEntity<Subject> getById(@PathVariable long id) {
        return ResponseEntity.ok(repo.findById(id).get());
    }
}

package br.dh.meli.sprintdata01.controller;

import br.dh.meli.sprintdata01.model.UserBD;
import br.dh.meli.sprintdata01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*") // pra nao dar problema de acesso - por padrao aceita requisicoes do mesmo dominio, com o cross tira essa validacao
@RequestMapping("/user")
public class UserDbController {

    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<UserBD> findById(@PathVariable long id) {
        return ResponseEntity.ok(service.getUserById(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserBD> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(service.findByEmail(email));
    }

    // criar user
    @PostMapping
    public ResponseEntity<UserBD> insertNewUser(@RequestBody UserBD user) {
        // TODO: validar se user tem id: disparar exception

        return ResponseEntity.status(HttpStatus.CREATED).body(service.insertUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<UserBD>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @PutMapping
    public ResponseEntity<UserBD> updateUser(@RequestBody UserBD user) {
        return ResponseEntity.ok(service.update(user));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserBD> updateUser(@PathVariable long id, @RequestBody Map<String, String> changes) {
        return ResponseEntity.ok(service.updatePartial(id, changes));
    }
}

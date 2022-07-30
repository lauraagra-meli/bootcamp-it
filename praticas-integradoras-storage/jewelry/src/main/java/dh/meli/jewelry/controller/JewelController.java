package dh.meli.jewelry.controller;

import dh.meli.jewelry.model.Jewel;
import dh.meli.jewelry.service.JewelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jewel")
public class JewelController {

    @Autowired
    private JewelService service;

    @PostMapping("/insert")
    public ResponseEntity<Jewel> insertNewJewel(@RequestBody Jewel jewel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insertNewJewel(jewel));
    }

    @GetMapping
    public ResponseEntity<List<Jewel>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Jewel>> listById(@PathVariable long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJewel(@PathVariable long id) {
//        service.deleteJewel(id);
//        return ResponseEntity.noContent().build();

        Optional<Jewel> jewelFound = service.findById(id);

        if (jewelFound.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}

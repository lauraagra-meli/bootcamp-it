package com.dh.meli.spring02.controller;

import com.dh.meli.spring02.model.Vehicle;
import com.dh.meli.spring02.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleRepo repo;

    @GetMapping("/{plaque}")
    public ResponseEntity<Vehicle> getVehicle(@PathVariable String plaque) {
        Vehicle v = repo.getVehicle(plaque);

        if (v != null) {
            return ResponseEntity.ok(v);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Vehicle>> getAllVehicle() {
        List<Vehicle> list = repo.getAllVehicle();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK) // caso sempre de ok, ao inves de fazer return ResponseEntity.ok(list);
    public void saveVehicle(@RequestBody Vehicle newVehicle) {
        repo.saveVehicle(newVehicle);
    }
}

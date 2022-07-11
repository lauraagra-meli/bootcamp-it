package com.dh.meli.spring02.controller;

import com.dh.meli.spring02.dto.VehicleDto;
import com.dh.meli.spring02.model.Vehicle;
import com.dh.meli.spring02.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired // injecao de dependencia
    private VehicleService service;

    @GetMapping("/{plaque}")
    public ResponseEntity<VehicleDto> getVehicle(@PathVariable String plaque) {
        return ResponseEntity.ok().body(service.getVehicle(plaque));

//        if (v != null) {
//            return ResponseEntity.ok(v);
//        }

//        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<VehicleDto>> getAllVehicle() {
        List<VehicleDto> list = service.getAllVehicle();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/allOrdered")
    public ResponseEntity<List<VehicleDto>> getAllVehicleOrdered() {
        List<VehicleDto> list = service.getAllVehicleByValue();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/allByModel")
    public ResponseEntity<List<VehicleDto>> getAllVehicleByModel() {
        List<VehicleDto> list = service.getAllVehicleByModel();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/byModel/{model}")
    public ResponseEntity<List<VehicleDto>> getByModel(@PathVariable String model) {
        List<VehicleDto> list = service.getByModel(model);
        return ResponseEntity.ok(list);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK) // caso sempre de ok, ao inves de fazer return ResponseEntity.ok(list);
    public void saveVehicle(@RequestBody Vehicle newVehicle) {
        service.saveVehicle(newVehicle);
    }
}

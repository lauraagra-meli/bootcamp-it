package com.dh.meli.spring02.dto;

// DTO = Data Transfer Object
// pra quando mexer no modelo, nao afetar a visualizacao do user

import com.dh.meli.spring02.model.Vehicle;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class VehicleDto {
    private String plaque;
    private String model;
    private double value;

    public VehicleDto(Vehicle vehicle) {
        this.plaque = vehicle.getPlaque();
        this.model = vehicle.getModel();
        this.value = vehicle.getValue();
    }
}

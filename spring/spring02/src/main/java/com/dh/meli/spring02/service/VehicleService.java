package com.dh.meli.spring02.service;

import com.dh.meli.spring02.dto.VehicleDto;
import com.dh.meli.spring02.model.Vehicle;

import java.util.List;

public interface VehicleService {
    VehicleDto getVehicle(String plaque);
    List<VehicleDto> getAllVehicle();
    void saveVehicle(Vehicle newVehicle);
    List<VehicleDto> getAllVehicleByValue();
    List<VehicleDto> getAllVehicleByModel();
    List<VehicleDto> getByModel(String model);
}

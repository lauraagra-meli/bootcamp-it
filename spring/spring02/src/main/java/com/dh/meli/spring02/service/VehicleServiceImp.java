package com.dh.meli.spring02.service;

import com.dh.meli.spring02.dto.VehicleDto;
import com.dh.meli.spring02.model.Vehicle;
import com.dh.meli.spring02.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImp implements VehicleService {
    @Autowired
    private VehicleRepo repo;

    @Override
    public VehicleDto getVehicle(String plaque) {
        VehicleDto vehicleDto = new VehicleDto(repo.getVehicle(plaque));
        return vehicleDto;
        //return repo.getVehicle(plaque);
    }

    @Override
    public List<VehicleDto> getAllVehicle() {
        List<Vehicle> vehicleList = repo.getAllVehicle();
        List<VehicleDto> newListDto = vehicleList.stream()
                .map(v -> new VehicleDto(v))
                .collect(Collectors.toList());

        return newListDto;

        //return repo.getAllVehicle();
    }

    @Override
    public void saveVehicle(Vehicle newVehicle) {
        repo.saveVehicle(newVehicle);
    }

    @Override
    public List<VehicleDto> getAllVehicleByValue() {
        List<Vehicle> listOfVehicles = repo.getAllVehicle();
        return listOfVehicles.stream()
                .sorted()
                .map(VehicleDto::new) // pega um conjnto de transforma em outro
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> getAllVehicleByModel() {
        List<Vehicle> listOfVehicles = repo.getAllVehicle();
        return listOfVehicles.stream()
                .sorted((v1, v2) -> v1.getModel().compareTo(v2.getModel()))
                .map(VehicleDto::new) // pega um conjnto de transforma em outro
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> getByModel(String model) {
        List<Vehicle> listOfVehicles = repo.getAllVehicle();
        return listOfVehicles.stream()
                .filter(v -> v.getModel().equals(model))
                .map(VehicleDto::new) // pega um conjnto de transforma em outro
                .collect(Collectors.toList());
    }

}

package com.dh.meli.spring02.repository;

import com.dh.meli.spring02.model.Vehicle;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class VehicleRepo {
    private final String linkFile = "src/main/resources/datas.json";

    public Vehicle getVehicle(String plaque) {
        Vehicle vehicle = null;
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> list = null;

        try {
            list = Arrays.asList(
                    mapper.readValue(new File(linkFile), Vehicle[].class));

            // criterio pra retornar o veiculo (passar a placa no final da url)
            for (Vehicle v:
                 list) {
                if (v.getPlaque().equals(plaque)) {
                    return v;
                }
            }
        } catch (Exception e) {

        }
        return null;
    }

    public List<Vehicle> getAllVehicle() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> list = null;

        try {
            list = Arrays.asList(
                    mapper.readValue(new File(linkFile), Vehicle[].class));
        } catch (Exception e) {

        }

        return list;
    }

    public void saveVehicle(Vehicle newVehicle) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer (new DefaultPrettyPrinter()); // formata o json bonitinho
        List<Vehicle> actualList = null;

        try {
            actualList = Arrays.asList(
                    mapper.readValue(new File(linkFile), Vehicle[].class));
            List<Vehicle> copyList = new ArrayList<>(actualList);

            copyList.add(newVehicle);
            writer.writeValue(new File(linkFile), copyList); // onde vai gravar e o que vai gravar
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

}

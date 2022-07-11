package com.dh.meli.spring02.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.LifecycleState;

import java.util.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
import java.util.List;

public class Owner {
    private int id;
    private String name;
    private String tel;
    private List<Vehicle> vehicles;

    //garantindo que a lista vai existir quando for acionar ele
    public void addVehicle(Vehicle v) {
        if (vehicles == null) {
            vehicles = new ArrayList<>();
        }

        vehicles.add(v);
    }

}

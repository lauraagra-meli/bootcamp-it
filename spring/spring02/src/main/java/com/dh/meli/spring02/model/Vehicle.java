package com.dh.meli.spring02.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle implements Comparable<Vehicle> {
    private String plaque;
    private String model;
    private double value;
    private String renavan;

    @Override
    public int compareTo(Vehicle other) {
        if (this.value > other.getValue())
            return 1;
        if (this.value < other.getValue())
            return -1;
        return 0;
    }
}

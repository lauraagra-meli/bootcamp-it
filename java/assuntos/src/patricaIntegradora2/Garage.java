package patricaIntegradora2;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private int id;
    private Vehicle vehicle;
    List<Vehicle> listOfVehicle = new ArrayList<Vehicle>();

    public Garage(int id, Vehicle vehicle, List<Vehicle> listOfVehicle) {
        this.id = id;
        this.vehicle = vehicle;
        this.listOfVehicle = listOfVehicle;
    }

    public Garage(int id, Vehicle vehicle) {
        this.id = id;
        this.vehicle = vehicle;
    }

    public Garage(List<Vehicle> listOfVehicle) {
    }

    public Garage() {
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<Vehicle> getListOfVehicle() {
        return listOfVehicle;
    }

    public void setListOfVehicle(List<Vehicle> listOfVehicle) {
        this.listOfVehicle = listOfVehicle;
    }

}

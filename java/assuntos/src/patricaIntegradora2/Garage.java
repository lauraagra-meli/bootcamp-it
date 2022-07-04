package patricaIntegradora2;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private Vehicle vehicle;

    List<Vehicle> listOfVehicle = new ArrayList<Vehicle>();

    public Garage(Vehicle vehicle, List<Vehicle> listOfVehicle) {
        this.vehicle = vehicle;
        this.listOfVehicle = listOfVehicle;
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

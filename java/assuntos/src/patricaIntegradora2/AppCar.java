package patricaIntegradora2;

import java.util.ArrayList;
import java.util.List;

public class AppCar {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        Garage garage = new Garage();


        List<Vehicle> list = garage.listOfVehicle;
        list.add(new Vehicle("Fiesta", "Ford", 32423));
        list.add(new Vehicle("Focus", "Ford", 22334));
        list.add(new Vehicle("Explorer", "Ford", 52342));
        list.add(new Vehicle("Uno", "Fiat", 234234));
        list.add(new Vehicle("Cronos", "Fiat", 342234));
        list.add(new Vehicle("Aveo", "Chevrolet", 12333));
        list.add(new Vehicle("Spin", "Chevrolet", 34213));
        list.add(new Vehicle("Corola", "Toyota", 85655));
        list.add(new Vehicle("Fortuner", "Toyota", 897666));

//        list.stream()
//                .sorted()
//                .forEach(System.out::println);

        System.out.println(list);
    }
}

package patricaIntegradora2;

import java.util.ArrayList;
import java.util.List;

public class AppCar {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        Garage garage = new Garage();


        List<Vehicle> list = garage.listOfVehicle;
        list.add(new Vehicle("Fiesta", "Ford", 1000));
        list.add(new Vehicle("Focus", "Ford", 600));
        list.add(new Vehicle("Explorer", "Ford", 32342));
        list.add(new Vehicle("Uno", "Fiat", 2000));
        list.add(new Vehicle("Cronos", "Fiat", 800));
        list.add(new Vehicle("Aveo", "Chevrolet", 5000));
        list.add(new Vehicle("Spin", "Chevrolet", 1000));
        list.add(new Vehicle("Corola", "Toyota", 9090));
        list.add(new Vehicle("Fortuner", "Toyota", 10000));

        System.out.println("Ordened list to PRICE: ");
        list.sort((v1, v2) -> v1.compareTo(v2));
        list.forEach(System.out::println);

        System.out.println("Ordened list to BRAND: ");
        list.sort((v1, v2) -> v1.compareToBrand(v2));
        list.forEach(System.out::println);

        System.out.println("Ordened list to PRICE: ");
        list.stream()
                        .filter(v -> v.getPrice());

        System.out.println(list);
    }
}

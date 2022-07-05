package patricaIntegradora2;

public class Vehicle implements Comparable<Vehicle> {
    private String model;
    private String brand;
    private double price;

    public Vehicle(String model, String brand, double price) {
        this.model = model;
        this.brand = brand;
        this.price = price;
    }

    public Vehicle() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Model: " + getModel() + " - Brand: " + getBrand() + " - Price: " + getPrice() + "\n";
    }

    @Override
    public int compareTo(Vehicle v) {
        return (int) (this.price - v.getPrice());
    }

    public int compareToBrand(Vehicle v) {
        return this.getBrand().compareTo(v.getBrand());
    }
}

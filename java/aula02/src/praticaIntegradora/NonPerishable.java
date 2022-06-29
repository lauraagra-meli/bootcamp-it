package praticaIntegradora;

public class NonPerishable extends Product {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public NonPerishable() {

    }

    public NonPerishable(String name, double price, String type) {
        super(name, price);
        this.type = type;
    }

    @Override
    public double calculate(int productsQuantity) {
        return price * productsQuantity;
    }

    @Override
    public String toString() {
        return null;
    }
}

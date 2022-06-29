package praticaIntegradora;

public class Perishable extends Product {
    private int daysToExpire;

    public int getDaysToExpire() {
        return daysToExpire;
    }

    public void setDaysToExpire(int daysToExpire) {
        this.daysToExpire = daysToExpire;
    }

    public Perishable() {

    }

    public Perishable(String name, double price, int daysToExpire) {
        super(name, price);
        this.daysToExpire = daysToExpire;
    }

    @Override
    public double calculate(int productsQuantity) {

        if (daysToExpire <= 1) {
            price /= 4;
        }
        if (daysToExpire <= 2) {
            price /= 3;
        }
        if (daysToExpire <= 3) {
            price /= 2;
        }

        return price * productsQuantity;
    }

    @Override
    public String toString() {
        return null;
    }
}

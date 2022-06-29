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

        if (daysToExpire == 1) {
            return (price / 4) * productsQuantity;
        }
        if (daysToExpire == 2) {
            return (price / 3) * productsQuantity;
        }
        if (daysToExpire == 3) {
            return (price / 2) * productsQuantity;
        }

        return price * productsQuantity;
    }

    @Override
    public String toString() {
        return "Product: " + getName() + " , unit value - " + getPrice() + " , total value ";
    }
}

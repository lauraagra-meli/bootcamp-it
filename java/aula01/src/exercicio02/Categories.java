package exercicio02;

public class Categories {
    private int idCategory;
    private String circuit;

    public Categories(int idCategory, String circuit) {
        this.idCategory = idCategory;
        this.circuit = circuit;
    }

    public Categories() {
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getCircuit() {
        return circuit;
    }

    public void setCircuit(String circuit) {
        this.circuit = circuit;
    }

    // methods

    public double calculate(double valueToPay) {
        return 0;
    }

    @Override
    public String toString() {
        return "circuito: " + circuit;
    }
}

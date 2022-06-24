package exemplo03;

public class Person {
    private String name;

    // construtor
    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // sobrescrevendo o metodo toString
    // pra transformar um endereco em texto
    @Override // sobrescrita - dar um novo significado
    public String toString() {
        return name;
    }
}


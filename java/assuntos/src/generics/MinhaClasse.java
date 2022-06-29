package generics;

// TRABALHAR COM DIFERENTES TIPOS DE DADOS

public class MinhaClasse<T> {
    T obj;

    public MinhaClasse(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }
}

package generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Exemplo02 {
    public static void main(String[] args) {
        MinhaClasse<Integer> obj = new MinhaClasse(123);
        MinhaClasse<String> obj1 = new MinhaClasse("texto");

        System.out.println(obj.getObj());
        System.out.println(obj1.getObj());

        // caracter coringa - lista de algo que voce nao sabe o que é inicialmente
        List<?> lista = new ArrayList();

        // usar mais de um tipo
        HashMap<Integer, String> mapa = new HashMap<>();
    }
}

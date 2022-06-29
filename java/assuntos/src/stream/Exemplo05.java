package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Exemplo05 {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1,2,3,4,5,6,7);

        Stream<Integer> stream = lista.stream();
        stream.forEach(n -> System.out.println(n));

        System.out.println("");

        lista.stream().map(n -> n * 2); // conjunto de entrada não é modificado
        lista.forEach(n -> System.out.println(n));

        System.out.println("LISTA ALTERADA");

        List<Integer> listaAlterada = lista.stream().map(n -> n * 2).toList();
        listaAlterada.forEach(n -> System.out.println(n));
    }
}

package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exemplo03 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numeros.forEach( n -> System.out.println(n)); // reescrevendo o foreach - passando uma funcao como parametro para um metodo
        numeros.forEach( n -> {
            if (n % 2 == 0) {
                System.out.println(n);
            }
        });

        for (Integer n:
             numeros) {
            System.out.println(n);
        }
    }

//    public boolean par(int n) {
//        return n % 2 ==0;
//    } // reescrevendo em expressao lambda embaixo

    //expressao lambda
    // lembra o arrow function do JS
//    n -> n % 2 ==0; // metodo escrito de uma forma reduzida
}

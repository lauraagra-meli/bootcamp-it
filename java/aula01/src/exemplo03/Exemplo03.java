package exemplo03;
// Loop FOR e WHILE

public class Exemplo03 {
    public static void main(String[] args) {
        int contador = 0;
        int contador2 = 0;
        int valor1 = 0;
        int valor2 = 0;

        valor1 = contador2++; // pós-incremento
        System.out.println(valor1);
        valor2 = ++contador2; // pré-incremento
        System.out.println(valor2);

        while (contador < 10) {

            System.out.println("contagem do while " + contador);
            contador++;
        }

        for (contador = 0; contador < 10; contador++) {
            System.out.println("contagem do for " + contador);
        }

    }
}

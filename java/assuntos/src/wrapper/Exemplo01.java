package wrapper;

public class Exemplo01 {
    public static void main(String[] args) {
        int n = 10; // tipo primitivo

        Integer integer = new Integer(10); // depreciado nas ultimas versões do java
        Integer integer1 = 10; // autoboxing: boxing conversion

        int valor = integer.intValue(); // pegar o valor da variavel
        int valor1 = integer; //outra forma de autoboxing

        System.out.println(integer);
        System.out.println(valor);

        int numero = Integer.parseInt("123"); // conversao

        Integer n1 = 200;
        Integer n2 = 200;

        System.out.println(n1 == n2); // quando falamos de classe, nao se compara o conteúdo, mas sim os objetos
        // obs: pra determinados valores abaixo de 125, ele dará true, pois reaproveita a memoria

        // soluçao para comparar objetos
        System.out.println(n1.equals(n2));

    }
}

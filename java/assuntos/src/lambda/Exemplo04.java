package lambda;

public class Exemplo04 {

    interface InterfaceString {
        String executar(String str);
    }

    public static void imprimir(String texto, InterfaceString inter) {
        String resultado = inter.executar(texto);
        System.out.println(resultado);
    }

    public static void main(String[] args) {
        InterfaceString mudar = s -> s + " complemento";

        imprimir("meu texto", mudar);
    }
}

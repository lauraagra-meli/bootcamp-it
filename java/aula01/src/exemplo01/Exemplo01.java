package exemplo01;
// Tipo de dados

public class Exemplo01 {
    //main = principal, ponto de inicio de execucao
    public static void main(String[] args) {
        int number;
        double numberDouble;

        number = ((12 + 3) * 5);

        numberDouble = 4.5;

        number = (int) numberDouble; //casting = conversão

        System.out.println("Hello World!");
        System.out.println("Result = " + number);
    }
}

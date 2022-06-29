package praticaIntegradora;

public class AppPessoa {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        Pessoa pessoa2 = new Pessoa("Laura", 21, "we123e1e");
        Pessoa pessoa3 = new Pessoa("Joana", 27, "de32r2", 68.2, 1.79);

        if (pessoa3.calcularIMC() == -1) {
            System.out.println("Abaixo do peso");
        }
        if (pessoa3.calcularIMC() == 0) {
            System.out.println("Peso saudável");
        }
        if (pessoa3.calcularIMC() == 1) {
            System.out.println("Sobrepeso");
        }

        System.out.println(pessoa3.toString());
        System.out.println(pessoa3.ehMaiorIdade());

    }
}

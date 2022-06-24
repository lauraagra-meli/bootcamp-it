package exemplo04;
// VETORES - array unidimensional

public class Exemplo04 {
    public static void main(String[] args) {
        final int tamanho = 5; // final transforma em constante
        int numbers[] = new int[tamanho];
        int [] a, b, c; //declaracao de varios arrays

        for (int i = 0; i < tamanho; i++) { // index
            numbers[i] = i;
            System.out.print(numbers[i] + " ");
        }
    }
}

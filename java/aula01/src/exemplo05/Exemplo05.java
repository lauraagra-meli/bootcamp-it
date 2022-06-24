package exemplo05;
// MATRIZES - Array bidimensional

public class Exemplo05 {
    public static void main(String[] args) {
        int [][] matriz = new int[3][4]; // linhas e colunas

        for (int i = 0; i < matriz.length; i++) { // percorre as linhas
            for (int j = 0; j < matriz[0].length; j++) { // percorre as colunas
                matriz[i][j] = i + j;
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
// PRIMEIRO LOOP DO PRIMEIRO FOR
// i0 j0 matriz posicao 0 0 = 0
// i0 j1 matriz posicao 0 1 = 1
// i0 j2 matriz posicao 0 2 = 2
// i0 j3 matriz posicao 0 3 = 3

// SEGUNDO LOOP DO PRIMEIRO FOR
// i1 j0 matriz posicao 1 0 = 1
// i1 j1 matriz posicao 1 1 = 2
// i1 j2 matriz posicao 1 2 = 3
// i1 j3 matriz posicao 1 3 = 4

// TERCEIRO LOOP DO PRIMEIRO FOR
// i2 j0 matriz posicao 2 0 = 2
// i2 j1 matriz posicao 2 1 = 3
// i2 j2 matriz posicao 2 2 = 4
// i2 j3 matriz posicao 2 3 = 5
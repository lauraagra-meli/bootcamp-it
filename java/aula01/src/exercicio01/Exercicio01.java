package exercicio01;

public class Exercicio01 {
    public static void main(String[] args) {
        String[] citiesVector = new String[]{"Londres", "Madrid", "Nova York", "Buenos Aires","Asuncion", "São Paulo", "Lima", "Santiago","Lisboa", "Tokio"}; // array de 10 posicoes
        int[][] degreesMatrix = {
                {-2, 33}, // 0,0 0,1
                {-3, 32}, // 1,0 1,1
                {-8, 27}, // 2,0 2,1
                {4, 37}, // 3,0 3,1
                {6, 42}, // 4,0 4,1
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 35}
        }; // matriz com 10 linhas e 2 colunas

        int minDegree = Integer.MIN_VALUE;
        int maxDegree = 0;
        String minCity = "";
        String maxCity = "";


        // percorrendo o vetor de cidades
        for (int i=0; i < citiesVector.length; i++) {
                for (int col = 0; col < degreesMatrix[0].length; col++) { // só precisa percorrer a coluna, porque a linha é a própria cidade
                    if (degreesMatrix[i][0] < minDegree) {
                        minDegree = degreesMatrix[i][0];
                        minCity = citiesVector[i];
                    }
                    if (degreesMatrix[i][1] > maxDegree) {
                        maxDegree = degreesMatrix[i][1];
                        maxCity = citiesVector[i];
                    }
                }
        }

        System.out.println("A temperatura mais baixa foi em " + minCity + ", com " + minDegree + "ºC.");
        System.out.print("A temperatura mais alta foi em " + maxCity + ", com " + maxDegree + "ºC.");
    }
}

// PRIMERIO LOOP DO PRIMEIRO FOR
// i0(Londres) f0 c0(-2) = Londres -2
// i0(Londres) f0 c1(33) = Londres 33

// SEGUNDO LOOP DO PRIMEIRO FOR
// i1(Madrid) f0 c0(-3) = Madrid -3
// i1(Madrid) f0 c1(32) = Madrid 32
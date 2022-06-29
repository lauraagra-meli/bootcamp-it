package exemplo05.modelo;

import exemplo05.modelo.utils.MongoDB;
import exemplo05.modelo.utils.MySQL;

import java.util.ArrayList;
import java.util.HashMap;

public class AppConta {

    public static void main(String[] args) {
        ContaCorrente cc1 = new ContaCorrente(111);
        ContaEspecial ce1 = new ContaEspecial(222, 1000);

        MySQL mySQL = new MySQL();
        MongoDB mongoDB = new MongoDB();

        // inserir varias contas
        ArrayList<Conta> listaDeContas = new ArrayList(); // usa classe dentro dos diamantes

        // HASH
        HashMap<Integer, Conta> mapaDeContas = new HashMap<>();

        listaDeContas.add(cc1); // adicionando as contas no array
        listaDeContas.add(ce1);

        // for
        for (int i = 0; i < listaDeContas.size(); i++) {
            System.out.println("Conta: " + listaDeContas.get(i).getNumero());
        }

        // foreach
        // c é a conta atual no momento do loop
        for (Conta c : listaDeContas) { // para cada: Conta da estrutura listaDeContas
            if (c.getNumero() == 111) {
                System.out.println("Conta encontrada no foreach: " + c.getNumero()); // pior cenario - percorre todas as contas
            }
        }

        // mandar pro banco
        cc1.gravar(mySQL);
        ce1.gravar(mongoDB);

        // USANDO HASH
        mapaDeContas.put(cc1.getNumero(), cc1);
        mapaDeContas.put(ce1.getNumero(), ce1);

        // buscas pontuais, não é bom pra percorrer
        Conta contaEncontrada = mapaDeContas.get(111);
        System.out.println("Conta encontrada no hashmap: " + contaEncontrada.getNumero()); // melhor cenario - passa direto na conta
    }
}

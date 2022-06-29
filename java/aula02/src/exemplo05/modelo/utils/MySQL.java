package exemplo05.modelo.utils;

import exemplo05.modelo.Conta;

public class MySQL implements BancoDeDados {

    @Override
    public void gravar(Conta conta) {
        System.out.printf("gravando no banco de dados MySQL a conta: %d\n", conta.getNumero());
    }
}

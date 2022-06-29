package exemplo05.modelo.utils;

import exemplo05.modelo.Conta;

public class MongoDB implements BancoDeDados {

    @Override
    public void gravar(Conta conta) {
        System.out.printf("gravando no banco de dados MongoDB a conta: %d\n", conta.getNumero());
    }
}

package exemplo05.modelo;

// conta pode ficar negativa ate certo valor

public class ContaEspecial extends Conta {
    private double limite;

    public ContaEspecial(int numero, double limite) {
        super(numero);
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= getSaldo() + limite) {
            super.sacar(valor);
        }
    }
}

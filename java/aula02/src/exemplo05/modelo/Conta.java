package exemplo05.modelo;

// CLASSE ABSTRATA

import exemplo05.modelo.utils.BancoDeDados;

public abstract class Conta {
    private int numero;
    private double saldo;

    public Conta(int numero) {
        this.numero = numero;
        this.saldo = 0;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        saldo -= valor;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void gravar(BancoDeDados banco) {
        banco.gravar(this); // gravar a propria conta (this)
    }

}

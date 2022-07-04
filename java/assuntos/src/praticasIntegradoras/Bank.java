package praticasIntegradoras;

public abstract class Bank implements Deposit, Transfers, Withdraws, Queries {
    private int agency;
    private int account;
    private double balance;

    public Bank(int agency, int account, double balance) {
        this.agency = agency;
        this.account = account;
        this.balance = balance;
    }

    public boolean transactionOk() {
        return false;
    }

    public boolean transactionNotOk() {
        return false;
    }

    public double deposit() {
        return 0;
    }
    public boolean withdraw() {
        return false;
    }
    public double transfer() {
        return 0;
    }
    public void query() {

    }



}

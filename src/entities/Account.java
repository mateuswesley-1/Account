package entities;

import exceptions.DomainException;

public class Account {

    private String id;
    private String holder;
    private double balance;
    private double withdrawLimit;
    static private String current_id = "00001";

    public Account(String holder, double balance, double withdrawLimit){

        // recebe a variavel estatica que conta quantos contas foram abertas
        this.id = current_id;
        current_id = String.format("%05d", Integer.parseInt(current_id) + 1);

        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Account(String holder, double withdrawLimit){

        this.id = current_id;
        current_id = String.format("%05d", Integer.parseInt(current_id) + 1);

        this.holder = holder;
        this.withdrawLimit = withdrawLimit;
        this.balance = 0.0;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount) throws DomainException{

        if(amount > balance){
            throw new DomainException("Valor de saque menor que valor de saldo. Saldo disponivel: " + balance);
        }

        if(amount > withdrawLimit){
            throw new DomainException("Valor de saque maior que o limite. Limite de saque: " + withdrawLimit);
        }

        balance -= amount;

    }

    public String getid() {
        return id;
    }

    protected void setid(String id) {
        this.id = id;
    }

    public String getHolder() {
        return holder;
    }

    protected void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    protected void setWithdrawLimit(double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Conta " + id);
        str.append("\nNome: " + holder);
        str.append("\nSaldo: " + balance);
        return str.toString();
    }
}

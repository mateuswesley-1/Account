package application;

import entities.Account;
import exceptions.DomainException;

public class Program {


    public static void main(String[] args) throws DomainException {

        Account conta1 = new Account("mateus", 800);
        Account conta2 = new Account("amanda", 500);

        System.out.println("\nContas criadas!!! \n");
        System.out.println("\n" + conta1.toString());
        System.out.println("\n" + conta2.toString());

        System.out.println("\nRealizando deposito... \n");
        conta1.deposit(5000);
        conta2.deposit(5000);

        System.out.println("Status atual: ");
        System.out.println("\n" + conta1.toString());
        System.out.println("\n" + conta2.toString());

        System.out.println("\nRealizando saque... \n");
        conta1.withdraw(50000);
        conta2.withdraw(50000);

    }
}

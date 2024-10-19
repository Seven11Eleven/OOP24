package oop24.Lab2.problem3;

public class TestBank {
    public static void main(String[] args) {
        Bank banka = new Bank();

        Account account = new Account(1001);
        SavingsAccount savingsAccount = new SavingsAccount(1002, 5.0);
        CheckingAccount checkingAccount = new CheckingAccount(1003);

        banka.openAccount(account);
        banka.openAccount(savingsAccount);
        banka.openAccount(checkingAccount);

        account.deposit(500);
        account.withdraw(200);

        savingsAccount.deposit(1000);
        savingsAccount.withdraw(300);

        checkingAccount.deposit(800);
        checkingAccount.withdraw(100);
        checkingAccount.deposit(200);
        checkingAccount.withdraw(50);

        banka.updateAccounts();

        banka.printAccounts();

        banka.closeAccount(1001);

        System.out.println("\nПосле закрытия счета 1001:");
        banka.printAccounts();
    }
}

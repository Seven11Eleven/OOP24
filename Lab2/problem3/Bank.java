package oop24.Lab2.problem3;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void openAccount(Account account) {
        accounts.add(account);
        System.out.println("Открыт новый счет: " + account.getAccountNumber());
    }

    public void closeAccount(int accNumber) {
        Account accountToRemove = null;
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accNumber) {
                accountToRemove = acc;
                break;
            }
        }
        if (accountToRemove != null) {
            accounts.remove(accountToRemove);
            System.out.println("Счет закрыт: " + accNumber);
        } else {
            System.out.println("Счет не найден: " + accNumber);
        }
    }

    public void updateAccounts() {
        for (Account acc : accounts) {
            if (acc instanceof SavingsAccount) {
                ((SavingsAccount) acc).addInterest();
            } else if (acc instanceof CheckingAccount) {
                ((CheckingAccount) acc).deductFees();
            }
        }
    }

    public void printAccounts() {
        for (Account acc : accounts) {
            acc.print();
        }
    }
}

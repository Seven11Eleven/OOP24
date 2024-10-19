package oop24.Lab2.problem3;

public class Account {
    private double balance; // The current balance
    private int accNumber; // The account number

    public Account(int accNumber) {
        this.balance = 0.0;
        this.accNumber = accNumber;
    }

    public void deposit(double sum) {
        if (sum > 0) {
            balance += sum;
        } else {
            System.out.println("Сумма депозита должна быть положительной");
        }
    }

    public void withdraw(double sum) {
        if (sum > 0) {
            if (balance >= sum) {
                balance -= sum;
            } else {
                System.out.println("Недостаточно средств на счете");
            }
        } else {
            System.out.println("Сумма снятия должна быть положительной");
        }
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accNumber;
    }
    public void transfer(double amount, Account other) {
        if (amount > 0) {
            if (balance >= amount) {
                this.withdraw(amount);
                other.deposit(amount);
            } else {
                System.out.println("Недостаточно средств для перевода");
            }
        } else {
            System.out.println("Сумма перевода должна быть положительной");
        }
    }

    @Override
    public String toString() {
        return "Account Number: " + accNumber + ", Balance: $" + balance;
    }

    public final void print() {
        System.out.println(toString());
    }
}
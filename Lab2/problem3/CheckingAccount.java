package oop24.Lab2.problem3;

public class CheckingAccount extends Account {
    private int transactionCount;
    private static int FREE_TRANSACTIONS = 3;
    private static final double TRANSACTION_FEE = 0.02;

    public CheckingAccount(int accNumber) {
        super(accNumber);
        this.transactionCount = 0;
    }

    @Override
    public void deposit(double sum) {
        super.deposit(sum);
        transactionCount++;
    }

    @Override
    public void withdraw(double sum) {
        super.withdraw(sum);
        transactionCount++;
    }

    public void deductFees() {
        if (transactionCount > FREE_TRANSACTIONS) {
            int extraTransactions = transactionCount - FREE_TRANSACTIONS;
            double fees = extraTransactions * TRANSACTION_FEE;
            if (getBalance() >= fees) {
                super.withdraw(fees);
            } else {
                System.out.println("Недостаточно средств для вычета комиссии");
            }
        }
        transactionCount = 0;
    }

    @Override
    public String toString() {
        return "Checking " + super.toString() + ", Transactions: " + transactionCount;
    }
}

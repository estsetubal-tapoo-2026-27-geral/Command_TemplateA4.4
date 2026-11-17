package command;

import java.util.Objects;

/** Receiver that performs the actual account operations. */
public class BankAccount {
    private final String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = Objects.requireNonNull(accountHolder, "accountHolder");
        if (!Double.isFinite(initialBalance) || initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance must be finite and non-negative");
        }
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        checkAmount(amount);
        if (!Double.isFinite(balance + amount)) {
            throw new IllegalArgumentException("Resulting balance must be finite");
        }
        balance += amount;
    }

    /**
     * Withdraws the requested amount.
     * @throws IllegalStateException if the account has insufficient funds
     */
    public void withdraw(double amount) {
        checkAmount(amount);
        if (amount > balance) {
            throw new IllegalStateException("Insufficient balance");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    private void checkAmount(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException("Amount must be finite and positive");
        }
    }
}

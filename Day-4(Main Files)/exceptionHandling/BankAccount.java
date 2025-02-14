package com.day4.exceptionHandling;


// Custom exception for insufficient balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
// BankAccount class with withdraw method and exception handling
public class BankAccount {
    private double balance;

    // Constructor to initialize balance
    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }

        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }

        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }

    // Getter for the balance
    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        // Create a BankAccount instance
        BankAccount account = new BankAccount(1000);

        // Try to perform withdrawals
        try {
            account.withdraw(200); // Valid withdrawal
            account.withdraw(1500); // Insufficient balance
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage()); // Handle insufficient balance
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Handle invalid amount
        }

        try {
            account.withdraw(-50); // Invalid amount
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage()); // Handle insufficient balance
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Handle invalid amount
        }
    }
}

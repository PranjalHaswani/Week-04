package com.day5.JUnit.AdvancedProblems;

public class BankAccount {
    private double balance;

    // Constructor to initialize the balance
    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0.0;  // If the initial balance is negative, set to 0.
        }
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be greater than 0.");
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }

    // Main method to test the BankAccount class
    public static void main(String[] args) {
        // Create a BankAccount instance with an initial balance
        BankAccount myAccount = new BankAccount(1000.0);

        // Display the current balance
        System.out.println("Current Balance: $" + myAccount.getBalance());

        // Test deposit method
        myAccount.deposit(500.0);
        System.out.println("Updated Balance: $" + myAccount.getBalance());

        // Test withdraw method
        myAccount.withdraw(300.0);
        System.out.println("Updated Balance: $" + myAccount.getBalance());

        // Try withdrawing more money than the balance
        myAccount.withdraw(1500.0);
        System.out.println("Updated Balance: $" + myAccount.getBalance());
    }
}

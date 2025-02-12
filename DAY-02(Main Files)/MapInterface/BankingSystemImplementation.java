package com.day2.collections.MapInterface;

import java.util.*;

class BankingSystem {
    private Map<String, Double> customerAccounts; // Account number -> balance
    private Map<Double, String> customersByBalance; // Sort customers by balance (TreeMap)
    private Queue<WithdrawalRequest> withdrawalRequests; // Queue for withdrawal requests

    public BankingSystem() {
        customerAccounts = new HashMap<>();
        customersByBalance = new TreeMap<>();
        withdrawalRequests = new LinkedList<>();
    }

    // Add a customer with an initial balance
    public void addCustomer(String accountNumber, double initialBalance) {
        customerAccounts.put(accountNumber, initialBalance);
        customersByBalance.put(initialBalance, accountNumber);
    }

    // Get the balance of a customer
    public double getBalance(String accountNumber) {
        return customerAccounts.getOrDefault(accountNumber, 0.0);
    }

    // Request a withdrawal (with an amount to be withdrawn)
    public void requestWithdrawal(String accountNumber, double amount) {
        if (getBalance(accountNumber) >= amount) {
            withdrawalRequests.offer(new WithdrawalRequest(accountNumber, amount)); // Store withdrawal request
        } else {
            System.out.println("Insufficient funds for withdrawal request for account " + accountNumber);
        }
    }

    // Process withdrawal requests from the queue
    public void processWithdrawals() {
        while (!withdrawalRequests.isEmpty()) {
            WithdrawalRequest request = withdrawalRequests.poll(); // Get the request
            String accountNumber = request.accountNumber;
            double requestedAmount = request.amount; // The actual withdrawal amount

            double currentBalance = getBalance(accountNumber); // Current balance of the account

            if (currentBalance >= requestedAmount) {
                // Process the withdrawal by subtracting the requested amount
                double newBalance = currentBalance - requestedAmount;
                customerAccounts.put(accountNumber, newBalance); // Update balance

                // Update the sorted map to reflect the new balance
                customersByBalance.put(newBalance, accountNumber);

                System.out.println("Processed withdrawal of " + requestedAmount + " from account " + accountNumber);
                System.out.println("New balance: " + newBalance);
            } else {
                System.out.println("Insufficient funds for account " + accountNumber);
            }
        }
    }

    // Class for withdrawal request: account number and requested withdrawal amount
    private static class WithdrawalRequest {
        String accountNumber;
        double amount;

        WithdrawalRequest(String accountNumber, double amount) {
            this.accountNumber = accountNumber;
            this.amount = amount;
        }
    }

    // Display all customer accounts and their balances
    public void displayAllCustomers() {
        customerAccounts.forEach((accountNumber, balance) -> {
            System.out.println("Account: " + accountNumber + " | Balance: " + balance);
        });
    }

    // Display customers sorted by balance
    public void displayCustomersSortedByBalance() {
        customersByBalance.forEach((balance, accountNumber) -> {
            System.out.println("Account: " + accountNumber + " | Balance: " + balance);
        });
    }
}

public class BankingSystemImplementation {
    public static void main(String[] args) {
        // Create the banking system instance
        BankingSystem bank = new BankingSystem();

        // Add customers with initial balances
        bank.addCustomer("A123", 1000.0);
        bank.addCustomer("B456", 500.0);
        bank.addCustomer("C789", 1500.0);
        bank.addCustomer("D101", 300.0);

        // Display all customers and their balances
        bank.displayAllCustomers();

        // Request some withdrawals
        bank.requestWithdrawal("A123", 100.0); // Valid request
        bank.requestWithdrawal("B456", 600.0); // Insufficient funds
        bank.requestWithdrawal("C789", 500.0); // Valid request
        bank.requestWithdrawal("D101", 200.0); // Insufficient funds

        // Process the withdrawal requests in the queue
        bank.processWithdrawals();

        // Display customers sorted by balance after withdrawals
        bank.displayCustomersSortedByBalance();
    }
}

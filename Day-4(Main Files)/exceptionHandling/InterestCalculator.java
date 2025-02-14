package com.day4.exceptionHandling;

public class InterestCalculator {

    // Method to calculate interest
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        // Check if the amount or rate is negative
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Amount and rate must be positive");
        }
        // Calculate and return interest
        return amount * rate * years / 100;
    }

    public static void main(String[] args) {
        try {
            // Example input
            double amount = 1000;  // Principal amount
            double rate = 1;       // Interest rate
            int years = 2;         // Duration in years

            // Calculate interest and print it
            double interest = calculateInterest(amount, rate, years);
            System.out.println("Calculated interest: " + interest);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }
}


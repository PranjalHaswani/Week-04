package com.day5.JUnit.AdvancedProblems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    private BankAccount account;

    // Set up method to initialize a new BankAccount before each test
    @BeforeEach
    public void setUp() {
        // Create a BankAccount instance with an initial balance of 1000
        account = new BankAccount(1000.0);
    }

    // Test for deposit functionality
    @Test
    public void testDeposit() {
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance(), "Balance should be 1500 after deposit of 500");

        // Test deposit of invalid amount
        account.deposit(-100.0);
        assertEquals(1500.0, account.getBalance(), "Balance should remain 1500 after trying to deposit a negative amount");
    }

    // Test for withdraw functionality
    @Test
    public void testWithdraw() {
        account.withdraw(300.0);
        assertEquals(700.0, account.getBalance(), "Balance should be 700 after withdrawal of 300");

        // Test withdrawing more money than available
        account.withdraw(800.0);
        assertEquals(700.0, account.getBalance(), "Balance should remain 700 after attempting to withdraw more than available");

        // Test invalid withdrawal amount (negative)
        account.withdraw(-100.0);
        assertEquals(700.0, account.getBalance(), "Balance should remain 700 after trying to withdraw a negative amount");
    }

    // Test for initial balance
    @Test
    public void testInitialBalance() {
        assertEquals(1000.0, account.getBalance(), "Initial balance should be 1000");
    }

    // Test for deposit edge case
    @Test
    public void testDepositEdgeCase() {
        account.deposit(0.0);
        assertEquals(1000.0, account.getBalance(), "Balance should remain 1000 after depositing 0");
    }

    // Test for withdraw edge case
    @Test
    public void testWithdrawEdgeCase() {
        account.withdraw(0.0);
        assertEquals(1000.0, account.getBalance(), "Balance should remain 1000 after withdrawing 0");
    }
}

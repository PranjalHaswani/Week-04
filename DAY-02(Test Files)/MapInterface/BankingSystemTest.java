package com.day2.collections.MapInterface;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankingSystemTest {

    private BankingSystem bank;

    @BeforeEach
    public void setUp() {
        bank = new BankingSystem();

        // Adding test customers with initial balances
        bank.addCustomer("A123", 1000.0);
        bank.addCustomer("B456", 500.0);
        bank.addCustomer("C789", 1500.0);
        bank.addCustomer("D101", 300.0);
    }

    @Test
    public void testRequestWithdrawal() {
        // Request withdrawal of 200.0 from account "A123"
        bank.requestWithdrawal("A123", 200.0);

        // Process withdrawal
        bank.processWithdrawals();

        // After processing, "A123" should have 800.0 balance
        assertEquals(800.0, bank.getBalance("A123"));
    }

    @Test
    public void testProcessWithdrawals() {
        // Request withdrawals for multiple accounts
        bank.requestWithdrawal("A123", 100.0); // Withdraw 100.0 from A123
        bank.requestWithdrawal("C789", 500.0); // Withdraw 500.0 from C789

        // Process the withdrawals
        bank.processWithdrawals();

        // After processing, A123 should have 900.0 and C789 should have 1000.0
        assertEquals(900.0, bank.getBalance("A123"));
        assertEquals(1000.0, bank.getBalance("C789"));
    }

    @Test
    public void testInsufficientFunds() {
        // Try withdrawing more than the balance (e.g., 600.0 from account "B456")
        bank.requestWithdrawal("B456", 600.0); // B456 has only 500.0

        // Process withdrawals (should not be processed due to insufficient funds)
        bank.processWithdrawals();

        // After processing, B456's balance should remain unchanged
        assertEquals(500.0, bank.getBalance("B456"));
    }
}

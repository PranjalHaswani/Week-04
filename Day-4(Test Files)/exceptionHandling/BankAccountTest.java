package com.day4.exceptionHandling;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    @Test
    public void testValidWithdrawal() throws InsufficientBalanceException {
        BankAccount account = new BankAccount(1000);
        account.withdraw(200);
        assertEquals(800, account.getBalance(), "Balance should be 800 after withdrawal");
    }

    @Test
    public void testInsufficientBalance() {
        BankAccount account = new BankAccount(1000);
        Exception exception = assertThrows(InsufficientBalanceException.class, () -> {
            account.withdraw(1500);
        });
        assertEquals("Insufficient balance!", exception.getMessage());
    }

    @Test
    public void testInvalidAmount() {
        BankAccount account = new BankAccount(1000);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-50);
        });
        assertEquals("Invalid amount!", exception.getMessage());
    }
}

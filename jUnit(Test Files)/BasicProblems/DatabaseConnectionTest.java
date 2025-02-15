package com.day5.JUnit.BasicProblems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class DatabaseConnectionTest {

    private DatabaseConnection dbConnection;

    // Initialize the database connection before each test
    @BeforeEach
    public void setUp() {
        dbConnection = new DatabaseConnection();
        dbConnection.connect();  // Establish connection
    }

    // Close the database connection after each test
    @AfterEach
    public void tearDown() {
        dbConnection.disconnect();  // Disconnect the database
    }

    // Test if the database connection is established correctly
    @Test
    public void testConnectionEstablishment() {
        assertTrue(dbConnection.isConnected(), "Database should be connected.");
    }

    // Test if the database connection is closed correctly after disconnection
    @Test
    public void testConnectionClosure() {
        dbConnection.disconnect();  // Disconnect manually
        assertFalse(dbConnection.isConnected(), "Database should be disconnected.");
    }

    // Test to ensure connection status remains true during test setup
    @Test
    public void testConnectionDuringTest() {
        assertTrue(dbConnection.isConnected(), "Database should be connected during the test.");
    }
}

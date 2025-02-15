package com.day5.JUnit.BasicProblems;

public class DatabaseConnection {

    private boolean isConnected;

    // Method to establish a database connection
    public void connect() {
        isConnected = true;
        System.out.println("Database connected.");
    }

    // Method to close the database connection
    public void disconnect() {
        isConnected = false;
        System.out.println("Database disconnected.");
    }

    // Getter for checking connection status (for test purposes)
    public boolean isConnected() {
        return isConnected;
    }

    public static void main(String[] args) {
        DatabaseConnection dbConnection = new DatabaseConnection();

        // Example of connecting and disconnecting
        dbConnection.connect();  // Establish connection
        System.out.println("Connection status: " + dbConnection.isConnected());

        dbConnection.disconnect();  // Disconnect the database
        System.out.println("Connection status: " + dbConnection.isConnected());
    }
}

package com.day2.collections.QueueInterface;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class HospitalTriageTest {

    @Test
    public void testTriageSystem() {
        // Initialize the triage system
        TriageSystem triage = new TriageSystem();

        // Add patients to the triage system
        triage.addPatient("John", 3);
        triage.addPatient("Alice", 5);
        triage.addPatient("Bob", 2);

        // Treat patients and get the order
        List<String> treatedPatients = triage.treatPatients();

        // Expected order of treated patients based on severity: ["Alice", "John", "Bob"]
        List<String> expectedOrder = Arrays.asList("Alice", "John", "Bob");

        // Assert that the order of treated patients is correct
        assertEquals(expectedOrder, treatedPatients);
    }
}


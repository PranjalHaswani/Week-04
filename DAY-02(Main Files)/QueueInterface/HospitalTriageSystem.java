package com.day2.collections.QueueInterface;

import java.util.*;

class Patient {
    String name;
    int severity;

    // Constructor
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for severity
    public int getSeverity() {
        return severity;
    }

    @Override
    public String toString() {
        return name;
    }
}

class TriageSystem {
    // PriorityQueue to manage patients by severity (max-heap)
    private PriorityQueue<Patient> queue;

    public TriageSystem() {
        // Comparator to prioritize patients with higher severity
        queue = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.getSeverity(), p1.getSeverity()));
    }

    // Add a patient to the queue
    public void addPatient(String name, int severity) {
        queue.add(new Patient(name, severity));
    }

    // Process and treat patients
    public List<String> treatPatients() {
        List<String> treatedPatients = new ArrayList<>();
        while (!queue.isEmpty()) {
            treatedPatients.add(queue.poll().getName());
        }
        return treatedPatients;
    }
}

public class HospitalTriageSystem {
    public static void main(String[] args) {
        // Initialize the triage system
        TriageSystem triage = new TriageSystem();

        // Add patients to the triage system
        triage.addPatient("John", 3);
        triage.addPatient("Alice", 5);
        triage.addPatient("Bob", 2);

        // Treat patients in order of severity
        List<String> treatedPatients = triage.treatPatients();

        // Output the order of treated patients
        System.out.println("Treated patients in order of severity: " + treatedPatients);
    }
}

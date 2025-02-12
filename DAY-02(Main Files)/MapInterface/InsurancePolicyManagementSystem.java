package com.day2.collections.MapInterface;

import java.util.*;
import java.text.*;

import java.util.Date;

class Policy {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public String toString() {
        return "Policy Number: " + policyNumber + ", Holder: " + policyholderName +
                ", Expiry: " + expiryDate + ", Coverage: " + coverageType + ", Premium: " + premiumAmount;
    }

    // Equals and hashcode based on policyNumber for HashSet functionality
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Policy policy = (Policy) o;
        return policyNumber.equals(policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return policyNumber.hashCode();
    }
}


class InsurancePolicyManager {
    private Set<Policy> hashSetPolicies = new HashSet<>();
    private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<Policy> treeSetPolicies = new TreeSet<>(Comparator.comparing(Policy::getExpiryDate));

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // Method to add a policy to all sets
    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    // Method to get all unique policies
    public void displayAllPolicies() {
        System.out.println("All Unique Policies:");
        hashSetPolicies.forEach(System.out::println);
    }

    // Method to get policies expiring soon (within the next 30 days)
    public void displayPoliciesExpiringSoon() {
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DATE, 30);  // 30 days from now
        Date dateAfter30Days = calendar.getTime();

        System.out.println("\nPolicies Expiring Soon:");
        for (Policy policy : hashSetPolicies) {
            if (policy.getExpiryDate().before(dateAfter30Days)) {
                System.out.println(policy);
            }
        }
    }

    // Method to get policies based on specific coverage type
    public void displayPoliciesByCoverage(String coverageType) {
        System.out.println("\nPolicies with Coverage Type: " + coverageType);
        for (Policy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(policy);
            }
        }
    }

    // Method to check for duplicate policies based on policy number
    public void displayDuplicatePolicies() {
        Set<String> uniquePolicyNumbers = new HashSet<>();
        System.out.println("\nDuplicate Policies:");
        for (Policy policy : hashSetPolicies) {
            if (!uniquePolicyNumbers.add(policy.getPolicyNumber())) {
                System.out.println(policy);
            }
        }
    }

    // Performance comparison method
    public void comparePerformance() {
        // Adding policies
        long startTime = System.nanoTime();
        addPolicy(new Policy("P1001", "Alice", new Date(System.currentTimeMillis() + 100000000L), "Health", 500));
        long endTime = System.nanoTime();
        System.out.println("\nAdd operation (HashSet): " + (endTime - startTime) + " ns");

        // Removing policies
        startTime = System.nanoTime();
        hashSetPolicies.remove(new Policy("P1001", "Alice", new Date(), "Health", 500));
        endTime = System.nanoTime();
        System.out.println("Remove operation (HashSet): " + (endTime - startTime) + " ns");

        // Searching for a policy
        startTime = System.nanoTime();
        hashSetPolicies.contains(new Policy("P1001", "Alice", new Date(), "Health", 500));
        endTime = System.nanoTime();
        System.out.println("Search operation (HashSet): " + (endTime - startTime) + " ns");
    }
}



public class InsurancePolicyManagementSystem {
    public static void main(String[] args) throws Exception {
        // Create the InsurancePolicyManager
        InsurancePolicyManager manager = new InsurancePolicyManager();

        // Create some policies
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date expiry1 = dateFormat.parse("2025-03-01");
        Date expiry2 = dateFormat.parse("2025-02-20");
        Date expiry3 = dateFormat.parse("2025-05-10");

        Policy policy1 = new Policy("P1001", "Alice", expiry1, "Health", 500);
        Policy policy2 = new Policy("P1002", "Bob", expiry2, "Auto", 300);
        Policy policy3 = new Policy("P1003", "Charlie", expiry3, "Home", 400);

        // Add policies to sets
        manager.addPolicy(policy1);
        manager.addPolicy(policy2);
        manager.addPolicy(policy3);

        // Display all unique policies
        manager.displayAllPolicies();

        // Display policies expiring soon
        manager.displayPoliciesExpiringSoon();

        // Display policies by coverage type
        manager.displayPoliciesByCoverage("Health");

        // Check for duplicate policies (for testing)
        manager.displayDuplicatePolicies();

        // Performance comparison
        manager.comparePerformance();
    }
}
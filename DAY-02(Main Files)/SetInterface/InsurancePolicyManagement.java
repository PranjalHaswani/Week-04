package com.day2.collections.SetInterface;

import java.time.LocalDate;   // Keep only this import
import java.util.*;

class Policy {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "Policy Number: " + policyNumber + ", Policyholder: " + policyholderName + ", Expiry Date: " + expiryDate;
    }
}



public class InsurancePolicyManagement {
    private Map<String, Policy> policyMap;           // Store policies with policy number as key (HashMap)
    private Map<String, Policy> linkedPolicyMap;    // Store policies maintaining insertion order (LinkedHashMap)
    private List<Policy> sortedPolicyList;          // Store policies in a list to sort by expiry date

    public InsurancePolicyManagement() {
        policyMap = new HashMap<>();
        linkedPolicyMap = new LinkedHashMap<>();
        sortedPolicyList = new ArrayList<>();
    }

    // Add a new policy
    public void addPolicy(Policy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        linkedPolicyMap.put(policy.getPolicyNumber(), policy);
        sortedPolicyList.add(policy);  // Add to the list for sorting by expiry date
        sortPoliciesByExpiryDate();   // Sort after adding
    }

    // Sort policies by expiry date
    public void sortPoliciesByExpiryDate() {
        sortedPolicyList.sort(Comparator.comparing(Policy::getExpiryDate));
    }

    // Retrieve a policy by its number
    public Policy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    // List policies expiring within the next 30 days
    public List<Policy> listPoliciesExpiringSoon() {
        List<Policy> expiringPolicies = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysLater = today.plusDays(30);

        for (Policy policy : policyMap.values()) {
            if (!policy.getExpiryDate().isBefore(today) && policy.getExpiryDate().isBefore(thirtyDaysLater)) {
                expiringPolicies.add(policy);
            }
        }
        return expiringPolicies;
    }

    // List all policies for a specific policyholder
    public List<Policy> listPoliciesByPolicyholder(String policyholderName) {
        List<Policy> policies = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.getPolicyholderName().equals(policyholderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<String, Policy>> iterator = policyMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Policy> entry = iterator.next();
            if (entry.getValue().getExpiryDate().isBefore(today)) {
                iterator.remove();
            }
        }
    }

    // Display all sorted policies
    public void displaySortedPolicies() {
        for (Policy policy : sortedPolicyList) {
            System.out.println(policy);
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManagement manager = new InsurancePolicyManagement();

        // Adding sample policies
        manager.addPolicy(new Policy("P123", "John Doe", LocalDate.of(2025, 3, 15)));
        manager.addPolicy(new Policy("P124", "Jane Smith", LocalDate.of(2025, 2, 20)));
        manager.addPolicy(new Policy("P125", "John Doe", LocalDate.of(2025, 5, 10)));

        // Display sorted policies by expiry date
        System.out.println("Policies sorted by expiry date:");
        manager.displaySortedPolicies();
    }
}
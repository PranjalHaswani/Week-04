package com.day2.collections.MapInterface;

import java.util.*;

 class Voting {
    private Map<String, Integer> votesMap;       // HashMap to store candidate votes
    private Map<String, Integer> linkedVotesMap; // LinkedHashMap to maintain order of voting
    private Map<Integer, String> sortedVotesMap; // TreeMap to sort candidates by number of votes

    public Voting() {
        votesMap = new HashMap<>();
        linkedVotesMap = new LinkedHashMap<>();
        sortedVotesMap = new TreeMap<>(Collections.reverseOrder()); // Sorted by votes in descending order
    }

    // Cast a vote for a candidate
    public void castVote(String candidate) {
        // Increase the vote count in HashMap
        votesMap.put(candidate, votesMap.getOrDefault(candidate, 0) + 1);

        // Maintain the insertion order in LinkedHashMap
        linkedVotesMap.put(candidate, votesMap.get(candidate));

        // Update the TreeMap with the latest vote count (sorted in descending order)
        sortedVotesMap.put(votesMap.get(candidate), candidate);
    }

    // Get the current vote count of a candidate
    public int getVotesForCandidate(String candidate) {
        return votesMap.getOrDefault(candidate, 0);
    }

    // Display the results in sorted order (highest to lowest votes)
    public void displayResultsSorted() {
        System.out.println("\nResults (Sorted by votes):");
        sortedVotesMap.forEach((votes, candidate) -> System.out.println(candidate + ": " + votes));
    }

    // Display the results in the order of voting (insertion order)
    public void displayResultsInsertionOrder() {
        System.out.println("\nResults (Insertion Order):");
        linkedVotesMap.forEach((candidate, votes) -> System.out.println(candidate + ": " + votes));
    }
}
public class VotingSystem {
    public static void main(String[] args) {
        // Create an instance of the Voting
        Voting votingSystem = new Voting();

        // Simulate voting
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Alice");

        // Display results in sorted order (by votes)
        votingSystem.displayResultsSorted();

        // Display results in insertion order (order of voting)
        votingSystem.displayResultsInsertionOrder();

        // Display vote count for a specific candidate
        System.out.println("\nVotes for Alice: " + votingSystem.getVotesForCandidate("Alice"));
        System.out.println("Votes for Bob: " + votingSystem.getVotesForCandidate("Bob"));
        System.out.println("Votes for Charlie: " + votingSystem.getVotesForCandidate("Charlie"));
    }
}

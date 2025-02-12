package com.day2.collections.MapInterface;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VotingSystemTest {
    private Voting votingSystem;

    @BeforeEach
    public void setUp() {
        votingSystem = new Voting();
    }

    @Test
    public void testVoteCounting() {
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");

        assertEquals(2, votingSystem.getVotesForCandidate("Alice"));
        assertEquals(1, votingSystem.getVotesForCandidate("Bob"));
        assertEquals(0, votingSystem.getVotesForCandidate("Charlie"));
    }

    @Test
    public void testSortedResults() {
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");

        // Sorted by votes (Descending order)
        // Alice: 2
        // Bob: 2
        // Charlie: 1
        votingSystem.displayResultsSorted();
    }

    @Test
    public void testInsertionOrder() {
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Charlie");

        // Insertion order should be Alice -> Bob -> Charlie
        votingSystem.displayResultsInsertionOrder();
    }

    @Test
    public void testNoVotesForNewCandidate() {
        assertEquals(0, votingSystem.getVotesForCandidate("Dave"));
    }
}

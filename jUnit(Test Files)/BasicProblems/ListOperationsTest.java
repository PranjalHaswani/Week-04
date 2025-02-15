package com.day5.JUnit.BasicProblems;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ListOperationsTest {

    private final ListOperations manager = new ListOperations();

    @Test
    void testAddElement() {
        List<Integer> list = new ArrayList<>();

        manager.addElement(list, 5);
        manager.addElement(list, 10);

        assertEquals(2, manager.getSize(list), "List size should be 2 after adding two elements");
        assertTrue(list.contains(5), "List should contain 5");
        assertTrue(list.contains(10), "List should contain 10");
    }

    @Test
    void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        manager.addElement(list, 5);
        manager.addElement(list, 10);

        // Test removing an element that exists
        boolean removed = manager.removeElement(list, 5);
        assertTrue(removed, "Element 5 should be removed");
        assertFalse(list.contains(5), "List should not contain 5 after removal");

        // Test removing an element that doesn't exist
        removed = manager.removeElement(list, 20);
        assertFalse(removed, "Removing non-existent element 20 should return false");

        assertEquals(1, manager.getSize(list), "List size should be 1 after removing one element");
    }

    @Test
    void testGetSize() {
        List<Integer> list = new ArrayList<>();
        assertEquals(0, manager.getSize(list), "List size should be 0 initially");

        manager.addElement(list, 5);
        manager.addElement(list, 10);
        assertEquals(2, manager.getSize(list), "List size should be 2 after adding two elements");

        manager.removeElement(list, 5);
        assertEquals(1, manager.getSize(list), "List size should be 1 after removing one element");
    }
}

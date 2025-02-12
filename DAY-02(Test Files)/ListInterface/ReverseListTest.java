package com.day2.collections.ListInterface;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseListTest {

    @Test
    public void testReverseArrayList() {
        ArrayList<Integer> inputList = new ArrayList<>();
        inputList.add(1);
        inputList.add(2);
        inputList.add(3);
        inputList.add(4);
        inputList.add(5);

        ArrayList<Integer> expectedReversed = new ArrayList<>();
        expectedReversed.add(5);
        expectedReversed.add(4);
        expectedReversed.add(3);
        expectedReversed.add(2);
        expectedReversed.add(1);

        ArrayList<Integer> actualReversed = ReverseList.reverseArrayList(inputList);

        // Assert that the reversed ArrayList matches the expected result
        assertEquals(expectedReversed, actualReversed);
    }

    @Test
    public void testReverseLinkedList() {
        LinkedList<Integer> inputList = new LinkedList<>();
        inputList.add(1);
        inputList.add(2);
        inputList.add(3);
        inputList.add(4);
        inputList.add(5);

        LinkedList<Integer> expectedReversed = new LinkedList<>();
        expectedReversed.add(5);
        expectedReversed.add(4);
        expectedReversed.add(3);
        expectedReversed.add(2);
        expectedReversed.add(1);

        LinkedList<Integer> actualReversed = ReverseList.reverseLinkedList(inputList);

        // Assert that the reversed LinkedList matches the expected result
        assertEquals(expectedReversed, actualReversed);
    }

    @Test
    public void testReverseEmptyArrayList() {
        ArrayList<Integer> inputList = new ArrayList<>();

        ArrayList<Integer> actualReversed = ReverseList.reverseArrayList(inputList);

        // Assert that the reversed ArrayList is still empty
        assertEquals(inputList, actualReversed);
    }

    @Test
    public void testReverseEmptyLinkedList() {
        LinkedList<Integer> inputList = new LinkedList<>();

        LinkedList<Integer> actualReversed = ReverseList.reverseLinkedList(inputList);

        // Assert that the reversed LinkedList is still empty
        assertEquals(inputList, actualReversed);
    }
}

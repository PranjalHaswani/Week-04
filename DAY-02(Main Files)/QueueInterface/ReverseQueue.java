package com.day2.collections.QueueInterface;

import java.util.*;

public class ReverseQueue {

    // Method to reverse the elements of the queue using recursion
    public static <T> void reverseQueue(Queue<T> queue) {
        // Base case: if the queue is empty, return
        if (queue.isEmpty()) {
            return;
        }

        // Step 1: Remove the front element of the queue
        T front = queue.remove();

        // Step 2: Reverse the rest of the queue recursively
        reverseQueue(queue);

        // Step 3: Add the front element to the back of the queue
        queue.add(front);
    }

    public static void main(String[] args) {
        // Test with a queue of integers
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        // Print original queue
        System.out.println("Original Queue: " + queue);

        // Reverse the queue
        reverseQueue(queue);

        // Print the reversed queue
        System.out.println("Reversed Queue: " + queue);
    }
}

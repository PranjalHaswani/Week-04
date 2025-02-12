package com.day2.collections.QueueInterface;
import java.util.*;

public class GenerateBinaryNumbers {

    // Method to generate the first N binary numbers using a queue
    public static List<String> generateBinaryNumbers(int N) {
        List<String> result = new ArrayList<>();

        if (N <= 0) return result;

        // Initialize the queue with the first binary number "1"
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        // Generate binary numbers until N are produced
        while (N-- > 0) {
            // Dequeue the front element
            String current = queue.poll();
            result.add(current);

            // Generate the next binary numbers and enqueue them
            queue.add(current + "0");
            queue.add(current + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        // Test case: Generate first 5 binary numbers
        int N = 5;
        List<String> binaryNumbers = generateBinaryNumbers(N);

        // Output the binary numbers
        System.out.println(binaryNumbers);
    }
}

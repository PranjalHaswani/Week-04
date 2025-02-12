package com.day2.collections.ListInterface;

import java.util.LinkedList;

public class ElementFind {

    // Method to find the Nth element from the end of the list
    public static <T> T findNthFromEnd(LinkedList<T> list, int N) {
        if (list == null || list.size() == 0 || N <= 0) {
            return null;
        }

        // Initialize two pointers: fast and slow
        var fast = list.listIterator();
        var slow = list.listIterator();

        // Move the fast pointer N steps ahead
        for (int i = 0; i < N; i++) {
            if (!fast.hasNext()) {
                return null;
            }
            fast.next();
        }

        // Move both pointers one step at a time until fast reaches the end
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        // Now, slow pointer is at the Nth element from the end
        return slow.next();
    }

    public static void main(String[] args) {
        // Test with an example
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        // Find the 2nd element from the end
        String result = findNthFromEnd(list, 2);
        System.out.println(result);
    }
}

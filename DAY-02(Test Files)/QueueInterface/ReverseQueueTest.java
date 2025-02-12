package com.day2.collections.QueueInterface;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class ReverseQueueTest {

    @Test
    public void testReverseQueue() {
        // Test case: Reverse a queue
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        // Expected reversed queue: [30, 20, 10]
        Queue<Integer> expectedQueue = new LinkedList<>();
        expectedQueue.add(30);
        expectedQueue.add(20);
        expectedQueue.add(10);

        // Reverse the queue and verify the result
        ReverseQueue.reverseQueue(queue);

        assertEquals(expectedQueue, queue);
    }
}

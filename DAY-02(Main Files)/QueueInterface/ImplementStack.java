package com.day2.collections.QueueInterface;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    // Constructor
    public ImplementStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // Push element onto stack
    public void push(int x) {
        // Push element into queue2
        queue2.add(x);

        // Push all the elements of queue1 into queue2
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }

        // Swap the names of queue1 and queue2 so that queue1 becomes the main queue
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // Remove the element on top of the stack
    public int pop() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue1.poll();
    }

    // Get the element on top of the stack
    public int top() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue1.peek();
    }

    // Check if the stack is empty
    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        // Test the ImplementStack
        ImplementStack stack = new ImplementStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Expected output: 3
        System.out.println("Top: " + stack.top());
        // Expected output: 3
        System.out.println("Pop: " + stack.pop());
        // Expected output: 2
        System.out.println("Top: " + stack.top());
    }
}

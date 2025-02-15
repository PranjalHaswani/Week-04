package com.day5.JUnit.BasicProblems;

public class TaskExecutor {

    // Method that simulates a long-running task
    public String longRunningTask() throws InterruptedException {
        // Simulating a task that takes 3 seconds to complete
        Thread.sleep(3000); // 3 seconds
        return "Task Completed";
    }

    public static void main(String[] args) {
        TaskExecutor executor = new TaskExecutor();

        try {
            // Calling long-running task
            String result = executor.longRunningTask();
            System.out.println(result);  // Expected output: "Task Completed"
        } catch (InterruptedException e) {
            System.out.println("Task interrupted.");
        }
    }
}

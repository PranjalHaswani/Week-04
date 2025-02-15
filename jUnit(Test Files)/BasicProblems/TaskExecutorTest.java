package com.day5.JUnit.BasicProblems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class TaskExecutorTest {

    private final TaskExecutor taskExecutor = new TaskExecutor();

    // Test to check if longRunningTask exceeds 2 seconds, which should fail
    @Test
    // Fail if test takes more than 2 seconds
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testLongRunningTask() throws InterruptedException {
        String result = taskExecutor.longRunningTask();
        assertEquals("Task Completed", result, "The task should complete successfully.");
    }
}

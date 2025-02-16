package com.day6.annotation.exerciseProblems;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

import java.lang.annotation.Repeatable;

// Define the repeatable annotation BugReport
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BugReports.class)  // Mark it as repeatable
@interface BugReport {
    String description();  // Description of the bug
}


// This container annotation holds multiple BugReport annotations
@Retention(RetentionPolicy.RUNTIME)
@interface BugReports {
    BugReport[] value();  // Array to hold BugReport annotations
}


class TaskManage {

    // Apply the @BugReport annotation twice on the method
    @BugReport(description = "Null pointer exception when accessing user data.")
    @BugReport(description = "UI freeze when loading large datasets.")
    public void processTask() {
        System.out.println("Processing the task...");
    }
}


public class RepeatableAnnotation {
    public static void main(String[] args) {
        try {
            // Get the TaskManager class
            Class<?> taskManagerClass = TaskManage.class;

            // Get the method processTask() from TaskManager class
            Method method = taskManagerClass.getMethod("processTask");

            // Retrieve the container annotation BugReports
            if (method.isAnnotationPresent(BugReports.class)) {
                // Get the BugReports annotation applied to the method
                BugReports bugReports = method.getAnnotation(BugReports.class);

                // Print all bug descriptions
                for (BugReport bugReport : bugReports.value()) {
                    System.out.println("Bug Description: " + bugReport.description());
                }
            } else {
                System.out.println("No bug reports found.");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

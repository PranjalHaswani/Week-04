package com.day6.annotation.exerciseProblems;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)  // Retain the annotation at runtime for reflection
@interface TaskInfo {
    String priority();  // Priority of the task
    String assignedTo();  // Person assigned to the task
}

class Manager {

    // Apply @TaskInfo annotation to a method
    @TaskInfo(priority = "High", assignedTo = "John Doe")
    public void completeTask() {
        System.out.println("Completing the task...");
    }
}


public class TaskManager {
    public static void main(String[] args) {
        try {
            // Get the TaskManager class
            Class<?> taskManagerClass = Manager.class;

            // Get the method completeTask() from TaskManager class
            Method method = taskManagerClass.getMethod("completeTask");

            // Check if the method has @TaskInfo annotation
            if (method.isAnnotationPresent(TaskInfo.class)) {
                // Get the TaskInfo annotation applied to the method
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

                // Print the annotation details
                System.out.println("Task Priority: " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
            } else {
                System.out.println("No TaskInfo annotation found.");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}


package com.day6.reflection.basiclLevel;

import java.lang.reflect.Constructor;

class Student {
    private String name;
    private int age;

    // Constructor to initialize name and age
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display Student details
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }
}

public class DynamicallyCreateStudent {

    public static void main(String[] args) {
        try {
            // Get the Class object for the Student class (using the full package name)
            Class<?> studentClass = Class.forName("com.day6.reflection.basiclLevel.Student");

            // Get the constructor of Student class that takes (String, int) parameters
            Constructor<?> constructor = studentClass.getConstructor(String.class, int.class);

            // Dynamically create an instance of Student using the constructor
            Object studentObj = constructor.newInstance("John Doe", 21);

            // Cast the object to Student type
            Student student = (Student) studentObj;

            // Call the displayInfo method to show the student details
            student.displayInfo();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

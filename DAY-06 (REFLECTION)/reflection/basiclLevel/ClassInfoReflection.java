package com.day6.reflection.basiclLevel;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.util.Scanner;


class Boy {
    private String name;
    private int age;

    // Constructor
    public Boy(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Default constructor
    public Boy() {
    }

    // Method
    public void greet() {
        System.out.println("Hello, my name is " + name + " and I am " + age + " years old.");
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }
}

public class ClassInfoReflection {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept class name from user input
        System.out.print("Enter the class name (e.g., Boy): ");
        String className = scanner.nextLine();

        try {
            // Get the Class object for the provided class name
            Class<?> clazz = Class.forName("com.day6.reflection.basiclLevel." + className); // full class name

            // Display class information
            System.out.println("\nClass: " + clazz.getName());

            // Display Constructors
            System.out.println("\nConstructors:");
            Constructor<?>[] constructors = clazz.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }

            // Display Methods
            System.out.println("\nMethods:");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }

            // Display Fields
            System.out.println("\nFields:");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

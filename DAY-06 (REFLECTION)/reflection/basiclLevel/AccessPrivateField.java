package com.day6.reflection.basiclLevel;

import java.lang.reflect.Field;

class Person {
    private int age;

    // Constructor to initialize the age
    public Person(int age) {
        this.age = age;
    }

    // Getter for age (optional for this example)
    public int getAge() {
        return age;
    }

    // Setter for age (optional for this example)
    public void setAge(int age) {
        this.age = age;
    }
}


public class AccessPrivateField {

    public static void main(String[] args) {
        try {
            // Create an instance of the Person class with an initial age of 25
            Person person = new Person(25);

            // Display the initial value of age using the getter
            System.out.println("Initial Age: " + person.getAge());

            // Use Reflection to access the private field 'age'
            Field ageField = Person.class.getDeclaredField("age");

            // Make the private field accessible
            ageField.setAccessible(true);

            // Modify the private field 'age' to 30
            ageField.set(person, 30);

            // Retrieve the modified value of age using Reflection
            System.out.println("Modified Age (via Reflection): " + ageField.get(person));

            // Optionally, verify using the getter method
            System.out.println("Modified Age (via Getter): " + person.getAge());

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

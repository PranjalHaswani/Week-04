package com.day6.annotation.exerciseProblems;

// Parent class Animal
class Animal {
    // Method to be overridden by subclasses
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Subclass Dog that extends Animal
class Dog extends Animal {
    // Override the makeSound() method to provide specific implementation for Dog
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

public class UsingOverRide {
    public static void main(String[] args) {
        // Create an instance of Dog
        Dog dog = new Dog();

        // Call the overridden makeSound() method
        dog.makeSound();
    }
}

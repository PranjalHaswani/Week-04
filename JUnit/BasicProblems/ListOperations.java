package com.day5.JUnit.BasicProblems;

import java.util.List;

public class ListOperations {

    // Method to add an element to a list
    public void addElement(List<Integer> list, int element) {
        if (list != null) {
            list.add(element);
        }
    }

    // Method to remove an element from a list
    public boolean removeElement(List<Integer> list, int element) {
        if (list != null && list.contains(element)) {
            return list.remove(Integer.valueOf(element));
        }
        return false;
    }

    // Method to get the size of the list
    public int getSize(List<Integer> list) {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public static void main(String[] args) {
        ListOperations manager = new ListOperations();

        List<Integer> list = new java.util.ArrayList<>();

        // Test addElement
        manager.addElement(list, 5);
        manager.addElement(list, 10);
        System.out.println("List after adding elements: " + list);  // [5, 10]

        // Test removeElement
        manager.removeElement(list, 5);
        System.out.println("List after removing 5: " + list);  // [10]

        // Test getSize
        System.out.println("Size of list: " + manager.getSize(list));  // 1
    }
}

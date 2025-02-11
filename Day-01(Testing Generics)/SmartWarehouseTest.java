package com.day1.generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartWarehouseTest {
    @Test
    void testElectronics() {
        Storage<Electronics> obj = new Storage<>();
        Storage<Electronics> obj2 = new Storage<>();
        Electronics laptop = new Electronics("Laptop");
        Electronics smartphone = new Electronics("Smartphone");
        obj.addItem(laptop);
        obj2.addItem(smartphone);
        assertEquals("Laptop", obj.getItems().get(0).getName());
        assertEquals("Smartphone", obj2.getItems().get(0).getName());
    }

    @Test
    void testFurniture() {
        Storage<Furniture> obj= new Storage<>();
        Storage<Furniture> obj2= new Storage<>();
        Furniture sofa= new Furniture("Sofa");
        Furniture chair= new Furniture("Chair");
        obj.addItem(sofa);
        obj2.addItem(chair);
        assertEquals("Sofa", obj.getItems().get(0).getName());
        assertEquals("Chair", obj2.getItems().get(0).getName());
    }
    @Test
    void testGroceries(){
        Storage<Groceries> obj= new Storage<>();
        Storage<Groceries> obj2= new Storage<>();
        Groceries apple= new Groceries("Apple");
        Groceries banana= new Groceries("Banana");
        obj.addItem(apple);
        obj2.addItem(banana);
        assertEquals("Apple", obj.getItems().get(0).getName());
        assertEquals("Banana", obj2.getItems().get(0).getName());
    }
}

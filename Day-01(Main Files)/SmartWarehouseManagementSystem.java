package com.day1.generics;

import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem{
     private  String name;

    public WarehouseItem(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    @Override
    public String toString(){
        return getClass(). getSimpleName()+ ": "+ name;
    }
}
//Subclass representing Groceries
class Groceries extends WarehouseItem{
    public Groceries(String name){
        super(name);
    }
}
//Subclass representing Electronics
class Electronics extends WarehouseItem{
    public Electronics(String name){
        super(name);
    }
}
//Subclass representing Furniture
class Furniture extends WarehouseItem{
    public Furniture(String name){
        super(name);
    }
}
//Generic class Storage to store items of type T that extends WarehouseItem
class Storage<T extends WarehouseItem>{
    private List<T> items= new ArrayList<>();

    //Method to add items to storage
    public void addItem(T item){
        items.add(item);
    }
    //Method to retrieve all items
    public List<T> getItems(){
        return items;
    }
    //Display items using wildcards
    public void displayItems(List<? extends WarehouseItem> itemList){
        for(WarehouseItem item: itemList){
            System.out.println(item);
        }
    }
}
public class SmartWarehouseManagementSystem {
    public static void main(String[] args) {
        //Create storage for different types of items
        Storage<Electronics> electronicsStorage= new Storage<>();
        Storage<Groceries> groceriesStorage= new Storage<>();
        Storage<Furniture> furnitureStorage= new Storage<>();

        //Add items to respective storages
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Smartphone"));

        groceriesStorage.addItem(new Groceries("Apple"));
        groceriesStorage.addItem(new Groceries("Banana"));

        furnitureStorage.addItem(new Furniture("Sofa"));
        furnitureStorage.addItem(new Furniture("Chair"));

        //Display all items in each storage using wildcard method
        System.out.println("Electonics in Storage: ");
        electronicsStorage.displayItems(electronicsStorage.getItems());

        System.out.println("\nGroceries in Storage: ");
        groceriesStorage.displayItems(groceriesStorage.getItems());

        System.out.println("\nFurniture in Storage: ");
        furnitureStorage.displayItems(furnitureStorage.getItems());
    }
}

package com.day2.collections.MapInterface;

import java.util.*;

 class Shopping {
     // HashMap to store product prices
    private Map<String, Double> productPrices;
     // LinkedHashMap to maintain order of added items
     Map<String, Integer> cartItems;
     // TreeMap to display items sorted by price
    private Map<Double, String> sortedItemsByPrice;

    public Shopping() {
        productPrices = new HashMap<>();
        cartItems = new LinkedHashMap<>();
        sortedItemsByPrice = new TreeMap<>();
    }

    // Add a product to the shopping cart
    public void addProduct(String product, int quantity) {
        cartItems.put(product, quantity);
    }

    // Set the price of a product
    public void setProductPrice(String product, double price) {
        productPrices.put(product, price);
    }

    // Get the price of a product
    public double getProductPrice(String product) {
        return productPrices.getOrDefault(product, 0.0);
    }

    // Calculate total price for all items in the cart
    public double calculateTotal() {
        double total = 0.0;
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();
            total += getProductPrice(product) * quantity;
        }
        return total;
    }

    // Display cart items in the order they were added (LinkedHashMap)
    public void displayItemsInsertionOrder() {
        System.out.println("\nItems in the order they were added:");
        cartItems.forEach((product, quantity) -> {
            double price = getProductPrice(product);
            System.out.println(product + " (x" + quantity + "): $" + price);
        });
    }

    // Display items sorted by price (TreeMap)
    public void displayItemsSortedByPrice() {
        System.out.println("\nItems sorted by price:");
        sortedItemsByPrice.clear();  // Clear previous items
        cartItems.forEach((product, quantity) -> {
            double price = getProductPrice(product);
            sortedItemsByPrice.put(price, product);
        });

        sortedItemsByPrice.forEach((price, product) -> {
            System.out.println(product + ": $" + price);
        });
    }
}
public class ShoppingCart {
    public static void main(String[] args) {
        // Create a ShoppingCart object
        Shopping cart = new Shopping();

        // Set product prices
        cart.setProductPrice("Laptop", 999.99);
        cart.setProductPrice("Headphones", 199.99);
        cart.setProductPrice("Mouse", 49.99);
        cart.setProductPrice("Keyboard", 79.99);
        cart.setProductPrice("Phone", 799.99);

        // Add items to the cart (product name and quantity)
        cart.addProduct("Laptop", 1);
        cart.addProduct("Headphones", 2);
        cart.addProduct("Mouse", 1);
        cart.addProduct("Keyboard", 1);
        cart.addProduct("Phone", 1);

        // Display items in the order they were added (LinkedHashMap)
        cart.displayItemsInsertionOrder();

        // Display items sorted by price (TreeMap)
        cart.displayItemsSortedByPrice();

        // Calculate and display the total price of items in the cart
        System.out.println("\nTotal price: $" + cart.calculateTotal());
    }
}

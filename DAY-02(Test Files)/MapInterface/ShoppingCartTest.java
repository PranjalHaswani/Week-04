package com.day2.collections.MapInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    private Shopping cart;

    @BeforeEach
    public void setUp() {
        // Initialize a new shopping cart before each test
        cart = new Shopping();

        // Set prices for products
        cart.setProductPrice("Laptop", 999.99);
        cart.setProductPrice("Headphones", 199.99);
        cart.setProductPrice("Mouse", 49.99);
        cart.setProductPrice("Keyboard", 79.99);
        cart.setProductPrice("Phone", 799.99);
    }

    @Test
    public void testAddProduct() {
        // Add products to the cart
        cart.addProduct("Laptop", 1);
        cart.addProduct("Phone", 2);

        // Check if prices are set correctly
        assertEquals(999.99, cart.getProductPrice("Laptop"));
        assertEquals(799.99, cart.getProductPrice("Phone"));

        // Check the quantities of the products in the cart
        assertEquals(1, cart.cartItems.get("Laptop"));
        assertEquals(2, cart.cartItems.get("Phone"));
    }

    @Test
    public void testCalculateTotal() {
        // Add products with quantities
        cart.addProduct("Laptop", 1);
        cart.addProduct("Phone", 2);
        cart.addProduct("Headphones", 1);

        // Expected total price: Laptop(999.99) + Phone(799.99*2) + Headphones(199.99)
        double expectedTotal = 999.99 + (2 * 799.99) + 199.99;
        assertEquals(expectedTotal, cart.calculateTotal());
    }

    @Test
    public void testDisplayItemsInsertionOrder() {
        cart.addProduct("Laptop", 1);
        cart.addProduct("Phone", 2);
        cart.addProduct("Headphones", 1);

        // You can visually check that the display is correct
        cart.displayItemsInsertionOrder();
    }

    @Test
    public void testDisplayItemsSortedByPrice() {
        cart.addProduct("Laptop", 1);
        cart.addProduct("Phone", 2);
        cart.addProduct("Headphones", 1);

        // Check that items are sorted by price
        cart.displayItemsSortedByPrice();
    }

    @Test
    public void testEmptyCart() {
        // Test for an empty cart
        assertEquals(0, cart.calculateTotal(), "Total price should be zero for an empty cart.");
    }

    @Test
    public void testProductNotInCart() {
        // Check for a product that hasn't been added to the cart
        cart.addProduct("Laptop", 1);
        assertEquals(999.99, cart.getProductPrice("Laptop"));
        assertEquals(0, cart.cartItems.getOrDefault("Tablet", 0));  // "Tablet" is not added
    }
}

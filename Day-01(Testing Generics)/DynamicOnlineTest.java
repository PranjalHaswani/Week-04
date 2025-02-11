package com.day1.generics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicOnlineTest {
        private ProductCatalog catalog;
        private Product<BookCategory> book;
        private Product<ClothingCategory> shirt;
        private Product<GadgetCategory> smartphone;

        @BeforeEach
        void setUp() {
            catalog = new ProductCatalog();

            book = new Product<>("Java Programming", 45.99, new BookCategory());
            shirt = new Product<>("Cotton Shirt", 29.99, new ClothingCategory());
            smartphone = new Product<>("Smartphone", 699.99, new GadgetCategory());

            catalog.addProduct(book);
            catalog.addProduct(shirt);
            catalog.addProduct(smartphone);
        }

        @Test
        void testProductCreation() {
            assertEquals("Java Programming", book.getName());
            assertEquals(45.99, book.getPrice(), 0.001);
            assertEquals("Book", book.getCategory().getName());

            assertEquals("Cotton Shirt", shirt.getName());
            assertEquals(29.99, shirt.getPrice(), 0.001);
            assertEquals("Clothing", shirt.getCategory().getName());

            assertEquals("Smartphone", smartphone.getName());
            assertEquals(699.99, smartphone.getPrice(), 0.001);
            assertEquals("Gadget", smartphone.getCategory().getName());
        }



        @Test
        void testApplyDiscount() {
            DiscountManager.applyDiscount(book, 10); // 10% off
            DiscountManager.applyDiscount(shirt, 15); // 15% off
            DiscountManager.applyDiscount(smartphone, 5); // 5% off

            assertEquals(41.39, book.getPrice(), 0.01);  // 45.99 - 10%
            assertEquals(25.49, shirt.getPrice(), 0.01); // 29.99 - 15%
            assertEquals(664.99, smartphone.getPrice(), 0.01); // 699.99 - 5%
        }
    }
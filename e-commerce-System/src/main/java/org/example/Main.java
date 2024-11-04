package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.model.Cart;
import org.example.model.Customer;
import org.example.model.Product;
import org.example.service.CheckoutService;
import org.example.service.ShippingService;

import java.util.Calendar;
import java.util.Date;


public class Main {
    static void testOne() {
        System.out.println("Test 1");
        try {
            Product cheese = new Product();//  expiration
            cheese.setName("cheese");
            cheese.setPrice(200.0);
            cheese.setWeight(0.5);
            cheese.setExpiryDate(new Date(2025, Calendar.FEBRUARY, 1));
            cheese.setQuantity(10);
            cheese.setShippable(true);
            Product tv = new Product(); // No expiration
            tv.setName("TV");
            tv.setPrice(400.0);
            tv.setWeight(2.00);
            tv.setQuantity(5);
            tv.setShippable(true);

            Product scratchCard = new Product(); // No expiration and No weight
            scratchCard.setName("Mobile Scratch Card");
            scratchCard.setPrice(50);
            scratchCard.setQuantity(20);
            // Create a customer
            Customer customer = new Customer("Abdo", 2000.0);
            // Create a cart and add products
            Cart cart = new Cart();
            cart.add(cheese, 2);
            cart.add(tv, 1);
            cart.add(scratchCard, 1);

            // Perform checkout
            ShippingService shippingService = new ShippingService();
            CheckoutService checkoutService = new CheckoutService(shippingService);
            checkoutService.checkOut(cart, customer);

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

    }

    static void testTwo() {
        System.out.println("Test 2");
        try {
            Product cheese = new Product();//  expiration
            cheese.setName("cheese");
            cheese.setPrice(200.0);
            cheese.setWeight(0.5);
            cheese.setExpiryDate(new Date(2025, Calendar.FEBRUARY, 1));
            cheese.setQuantity(10);
            cheese.setShippable(true);
            Product tv = new Product(); // No expiration
            tv.setName("TV");
            tv.setPrice(400.0);
            tv.setWeight(2.00);
            tv.setQuantity(5);
            tv.setShippable(true);

            Product scratchCard = new Product(); // No expiration and No weight
            scratchCard.setName("Mobile Scratch Card");
            scratchCard.setPrice(50);
            scratchCard.setQuantity(20);
            // Create a customer
            Customer customer = new Customer("Ahmed", 2000.0);
            // Create a cart and add products
            Cart cart = new Cart();
            cart.add(cheese, 3);
            cart.add(tv, 4);
            cart.add(scratchCard, 2);

            // Perform checkout
            ShippingService shippingService = new ShippingService();
            CheckoutService checkoutService = new CheckoutService(shippingService);
            checkoutService.checkOut(cart, customer);

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

    }

    static void testThree() {
        System.out.println("Test 3");
        try {

            Product scratchCard = new Product(); // No expiration and No weight
            scratchCard.setName("Mobile Scratch Card");
            scratchCard.setPrice(50);
            scratchCard.setQuantity(20);
            Product AmazonPromoCode = new Product(); // No expiration and No weight
            AmazonPromoCode.setName("Amazon PromoCode");
            AmazonPromoCode.setPrice(10);
            AmazonPromoCode.setQuantity(20);
            // Create a customer
            Customer customer = new Customer("Assmaa", 2000.0);
            // Create a cart and add products
            Cart cart = new Cart();
            cart.add(AmazonPromoCode, 5);
            cart.add(scratchCard, 6);

            // Perform checkout
            ShippingService shippingService = new ShippingService();
            CheckoutService checkoutService = new CheckoutService(shippingService);
            checkoutService.checkOut(cart, customer);

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public static void main(String[] args) {
        testOne();
        testTwo();
        testThree();

    }
}

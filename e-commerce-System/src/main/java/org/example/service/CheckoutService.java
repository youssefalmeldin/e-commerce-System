package org.example.service;

import org.example.model.Cart;
import org.example.model.Customer;
import org.example.model.Product;

import java.util.Currency;
import java.util.List;
import java.util.Map;

public class CheckoutService {
    ShippingService shippingService;

    public CheckoutService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }


    public double checkOut(Cart cart, Customer customer) {
        if (cart.isEmpty()) {
            throw new IllegalArgumentException("Error: Cart is empty");
        }
        double subtotal = 0;
        for (Map.Entry<Product, Integer> item : cart.getItems().entrySet()) {
            if (item.getKey().isExpired()) {
                throw new IllegalArgumentException(STR."Error: Product \{item.getKey().getName()} is expired.");
                // product.setQuantity(product.getQuantity() - quantity);
            }
            subtotal += item.getKey().getPrice() * item.getValue();
        }
        double shippingFees = shippingService.calculateShippingFees(cart.getItems());
        double totalAmount = subtotal + shippingFees;
        customer.decreaseBalance(totalAmount);

        printReceipt(cart, subtotal, shippingFees, totalAmount);
        for (Map.Entry<Product, Integer> item : cart.getItems().entrySet()) {
           item.getKey().setQuantity(item.getKey().getQuantity() - item.getValue());
        }
        return totalAmount;


    }

    public void printReceipt(Cart cart, double subtotal, double shippingFees, double totalAmount) {
        System.out.println("** Items notice **");

        double totalWeight = 0.0;
        for (Map.Entry<Product, Integer> item : cart.getItems().entrySet()) {
            if (item.getKey().isShippable()) {
                System.out.printf("Item: %s - Quantity: %d - Weight: %f\n", item.getKey().getName(), item.getValue(), item.getKey().getWeight());

                totalWeight += item.getKey().getWeight() * item.getValue();
            } else {
                System.out.printf("Item: %s - Quantity: %d \n", item.getKey().getName(), item.getValue());
            }

        }
        if (totalWeight > 0) {
            System.out.printf("Total package weight: %.1fkg%n\n", totalWeight);
        }

        System.out.println("** Checkout receipt **");
        System.out.printf("Subtotal         %.2f\n", subtotal);
        if (shippingFees > 0) {
            System.out.printf("Shipping         %.2f\n", shippingFees);
        }
        System.out.printf("Total Amount     %.2f\n", totalAmount);

    }
}

package org.example.model;

import org.example.model.Product;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> items;

    public Cart() {
        items = new HashMap<>();
    }

    public void add(Product product, int quantity) throws Exception {
        if (quantity <= product.getQuantity()) {
            items.put(product, quantity);
        } else {
            throw new Exception("Insufficient quantity available");
        }
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

}

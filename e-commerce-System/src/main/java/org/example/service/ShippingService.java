package org.example.service;

import org.example.model.Product;

import java.util.List;
import java.util.Map;

public class ShippingService {
    private static final double SHIPPING_FEES_FOR_KG = 10.0;

    public double calculateShippingFees(Map<Product, Integer> items) {

        double totalWeight = 0.0;
        for (Map.Entry<Product, Integer> item : items.entrySet()) {
            if (item.getKey().isShippable()) {
                totalWeight += item.getKey().getWeight() * item.getValue();
            }
        }

        return SHIPPING_FEES_FOR_KG * totalWeight;


    }
}

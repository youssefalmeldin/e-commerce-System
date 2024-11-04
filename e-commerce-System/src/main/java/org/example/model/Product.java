package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String name;
    private double price;
    private int quantity;
    private Date expiryDate;
    private boolean shippable;
    private double weight;


    public boolean isExpired() {
        if (expiryDate == null) {
            return false;
        }
        return expiryDate.before(new Date());
    }


}

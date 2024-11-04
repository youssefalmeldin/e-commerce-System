package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private String name;
    private double balance;


    public void decreaseBalance(double amount) {

        if (amount <= 0) throw new IllegalArgumentException("Error: Decreased amount must be positive ");
        else if (this.balance < amount) throw new IllegalArgumentException("Error: Your balance isn't sufficient ");
        else {
            this.balance -= amount;

        }
    }

    public void increaseBalance(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Error: Increased amount must be positive ");
        else {
            this.balance += amount;

        }
    }


}

package org.example.FoodOrderingSystem.Entity;

public class OrderItem {
    private String itemName;
    private int quantity;

    // Constructor
    public OrderItem(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }

    // Getters and setters
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

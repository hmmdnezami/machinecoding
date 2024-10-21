package org.example.FoodOrderingSystem.Entity;

public class MenuItem {
    private String itemName;
    private double price;

    // Default constructor
    public MenuItem() {
        this.price = 0.0;
    }

    // Parameterized constructor
    public MenuItem(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    // Getters and setters
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

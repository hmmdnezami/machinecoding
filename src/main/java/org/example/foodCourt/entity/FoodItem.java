package org.example.foodCourt.entity;

public class FoodItem {

    private String foodName ;
    private double price;
    private int quantity;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }



    public FoodItem(String foodName, double price, int quantity) {
        this.foodName = foodName;
        this.price = price;
        this.quantity = quantity;
    }

    public void addQuantity(int quantityToAdd) {
        this.quantity += quantityToAdd;
    }

    public void decreaseQuantity(int quantity) {
        this.quantity -= quantity;
    }
}

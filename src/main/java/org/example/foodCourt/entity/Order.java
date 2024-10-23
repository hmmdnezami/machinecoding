package org.example.foodCourt.entity;

public class Order {

    private int id ;
    private String restaurantNamel ;
    private int quantity ;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRestaurantNamel() {
        return restaurantNamel;
    }

    public void setRestaurantNamel(String restaurantNamel) {
        this.restaurantNamel = restaurantNamel;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Order(int id, String restaurantNamel, int quantity, double price) {
        this.id = id;
        this.restaurantNamel = restaurantNamel;
        this.quantity = quantity;
        this.price = price;
    }
}

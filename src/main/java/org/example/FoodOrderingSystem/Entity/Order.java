package org.example.FoodOrderingSystem.Entity;

import java.util.List;

public class Order {

    public enum OrderStatus {
        CREATED,
        ACCEPTED,
        COMPLETED
    }

    private OrderStatus status;
    private List<OrderItem> orderItems;
    private String orderId;
    private double price;
    private String restaurantName;
    private String user;

    // Constructor
    public Order(List<OrderItem> orderItems, String orderId, double price, String restaurantName, String user) {
        this.status = OrderStatus.CREATED;
        this.orderItems = orderItems;
        this.orderId = orderId;
        this.price = price;
        this.restaurantName = restaurantName;
        this.user = user;
    }

    // Getters and setters
    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}

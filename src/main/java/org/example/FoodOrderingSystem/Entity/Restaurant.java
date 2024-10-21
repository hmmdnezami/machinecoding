package org.example.FoodOrderingSystem.Entity;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class Restaurant {
    private String name;
    private int maxCapacity;
    private double rating;
    private List<MenuItem> menu;
    private List<Order> orders;

    // Constructor
    public Restaurant(String name, double rating, int maxOrders, List<MenuItem> menu) {
        this.name = name;
        this.rating = rating;
        this.maxCapacity = maxOrders;
        this.menu = menu;
        this.orders = new ArrayList<>(); // Initialize orders list
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public double getRating() {
        return rating;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public List<Order> getOrders() {
        return orders;
    }

    // Check if the restaurant can satisfy the order
    public boolean canSatisfyOrder(List<OrderItem> orderItems) {
        HashSet<String> itemNames = new HashSet<>();
        for (OrderItem orderItem : orderItems) {
            itemNames.add(orderItem.getItemName());
        }

        int matchingItems = 0;
        for (MenuItem menuItem : menu) {
            if (itemNames.contains(menuItem.getItemName())) {
                matchingItems++;
            }
        }

        return matchingItems == itemNames.size();
    }

    // Compute total price of the order
    public double computeOrderPrice(List<OrderItem> orderItems) {
        double price = 0;
        for (OrderItem orderItem : orderItems) {
            MenuItem menuItem = null;
            for (MenuItem item : menu) {
                if (item.getItemName().equals(orderItem.getItemName())) {
                    menuItem = item;
                    break;
                }
            }

            if (menuItem != null) {
                price += orderItem.getQuantity() * menuItem.getPrice();
            }
        }
        return price;
    }

    // Check if the restaurant can accept more orders
    public boolean canAcceptOrder() {
        return maxCapacity > orders.size();
    }

    // Add order to the restaurant
    public boolean addOrder(Order order) {
        if (!canAcceptOrder()) {
            return false;
        }
        orders.add(order);
        return true;
    }

    // Check if the restaurant contains an order by ID
    public boolean containsOrder(String orderId) {
        for (Order order : orders) {
            if (order.getOrderId().equals(orderId)) {
                return true;
            }
        }
        return false;
    }

    // Update the status of an order to 'Completed'
    public boolean updateOrder(String orderId) {
        if (!containsOrder(orderId)) {
            return false;
        }

        Order orderToUpdate = null;
        for (Order order : orders) {
            if (order.getOrderId().equals(orderId)) {
                orderToUpdate = order;
                break;
            }
        }

        if (orderToUpdate != null) {
            orderToUpdate.setStatus(Order.OrderStatus.COMPLETED);
            orders.remove(orderToUpdate);
            return true;
        }
        return false;
    }
}

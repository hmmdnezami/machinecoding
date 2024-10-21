package org.example.Restaurant.models;

import java.util.List;

public class Order {
    private int orderId;
    private int tableId;
    private List<FoodItems> foodItemsList;
    private boolean isPrepared;
    private boolean isServed;

    public Order(int tableId, List<FoodItems> orderItems) {
        this.tableId = tableId;
        this.foodItemsList = orderItems;
        this.isPrepared = false;
        this.isServed = false;
    }

}

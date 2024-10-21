package org.example.FoodOrderingSystem.Interface;


import org.example.FoodOrderingSystem.Entity.OrderItem;

import java.util.List;

public interface IOrderingService {
    String placeOrder(String userName, List<OrderItem> order, String strategy);
    void updateOrderStatus(String orderId);
}

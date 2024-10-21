package org.example.FoodOrderingSystem.Interface;


import org.example.FoodOrderingSystem.Entity.OrderItem;
import org.example.FoodOrderingSystem.Entity.Restaurant;

import java.util.List;

public interface IStrategy {
    Restaurant getRestaurant(List<Restaurant> restaurants, List<OrderItem> order, double[] amount);
}

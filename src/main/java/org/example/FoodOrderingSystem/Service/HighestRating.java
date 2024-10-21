package org.example.FoodOrderingSystem.Service;


import org.example.FoodOrderingSystem.Entity.OrderItem;
import org.example.FoodOrderingSystem.Entity.Restaurant;
import org.example.FoodOrderingSystem.Interface.IStrategy;

import java.util.List;

public class HighestRating implements IStrategy {
    @Override
    public Restaurant getRestaurant(List<Restaurant> restaurants, List<OrderItem> order, double[] amount) {
        amount[0] = 0;
        if (restaurants.isEmpty()) {
            return null;
        }

        double price = Double.MAX_VALUE;
        Restaurant bestRes = null;

        for (Restaurant res : restaurants) {
            double temp = res.computeOrderPrice(order);
            if (temp < price) {
                price = temp;
                bestRes = res;
            }
        }

        amount[0] = price;
        return bestRes;
    }
}

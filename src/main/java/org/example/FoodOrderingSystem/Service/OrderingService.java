package org.example.FoodOrderingSystem.Service;



import org.example.FoodOrderingSystem.Entity.Order;
import org.example.FoodOrderingSystem.Entity.OrderItem;
import org.example.FoodOrderingSystem.Entity.Restaurant;
import org.example.FoodOrderingSystem.Helpers.Logger;
import org.example.FoodOrderingSystem.Helpers.ServiceFactory;
import org.example.FoodOrderingSystem.Helpers.StrategyFactory;
import org.example.FoodOrderingSystem.Helpers.UniqueIdGenerator;
import org.example.FoodOrderingSystem.Interface.IOrderingService;
import org.example.FoodOrderingSystem.Interface.IStrategy;

import java.util.ArrayList;
import java.util.List;

public class OrderingService implements IOrderingService {
    private RestaurantService resService = ServiceFactory.getRestaurantService();
    private UniqueIdGenerator unqGen = new UniqueIdGenerator("Order");

    @Override
    public String placeOrder(String userName, List<OrderItem> order, String strategy) {
        String orderId = "none";
        try {
            List<Restaurant> restaurants = resService.getRestaurant();
            List<Restaurant> validRest = new ArrayList<>();
            for (Restaurant res : restaurants) {
                if (res.canSatisfyOrder(order)) {
                    validRest.add(res);
                }
            }
            IStrategy strat = StrategyFactory.getStrategy(strategy);
            double[] amount = new double[1];
            Restaurant res = strat.getRestaurant(validRest, order, amount);

            if (res == null) {
                System.out.println("No Restaurant Available!");
                return orderId;
            }

            Order ord = new Order(order, unqGen.getUid(), amount[0], res.getName(), userName);
            if (res.addOrder(ord)) {
                ord.setStatus(Order.OrderStatus.ACCEPTED);
                orderId = ord.getOrderId();
            } else {
                System.out.println("All Restaurants are booked!");
            }
        } catch (Exception ex) {
            System.out.println("Unknown Failure Occurred! Sorry For Inconvenience!");
            Logger.log("Place Order : " + ex.getMessage());
        }
        return orderId;
    }

    @Override
    public void updateOrderStatus(String orderId) {
        try {
            List<Restaurant> restaurants = resService.getRestaurant();
            List<Restaurant> resList = new ArrayList<>();
            for (Restaurant res : restaurants) {
                if (res.containsOrder(orderId)) {
                    resList.add(res);
                }
            }

            if (resList.isEmpty()) {
                System.out.println("No Such OrderId Found");
                return;
            }

            Restaurant res = resList.get(0);
            res.updateOrder(orderId);
            System.out.println("Order Updated!");
        } catch (Exception ex) {
            System.out.println("Unknown Failure Occurred! Sorry For Inconvenience!");
            Logger.log("Update Order : " + ex.getMessage());
        }
    }
}

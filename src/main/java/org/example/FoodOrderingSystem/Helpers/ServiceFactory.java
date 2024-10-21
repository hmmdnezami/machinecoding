package org.example.FoodOrderingSystem.Helpers;


import org.example.FoodOrderingSystem.Interface.IOrderingService;
import org.example.FoodOrderingSystem.Interface.IRestaurantService;
import org.example.FoodOrderingSystem.Service.OrderingService;
import org.example.FoodOrderingSystem.Service.RestaurantService;

public class ServiceFactory {
    private static RestaurantService restaurantService = null;
    private static OrderingService orderingService = null;

    public static IRestaurantService getRestaurantServiceForUser() {
        if (restaurantService == null) {
            restaurantService = new RestaurantService();
        }
        return restaurantService;
    }

    public static IOrderingService getOrderingServiceForUser() {
        if (orderingService == null) {
            orderingService = new OrderingService();
        }
        return orderingService;
    }

    public static RestaurantService getRestaurantService() {
        if (restaurantService == null) {
            restaurantService = new RestaurantService();
        }
        return restaurantService;
    }

    public static OrderingService getOrderingService() {
        if (orderingService == null) {
            orderingService = new OrderingService();
        }
        return orderingService;
    }
}



package org.example.foodCourt.Service;

import org.example.foodCourt.Helpers.UniqueId;
import org.example.foodCourt.Interface.IOrderingService;
import org.example.foodCourt.entity.Order;
import org.example.foodCourt.entity.Restaurant;

public class OrderingService implements IOrderingService {

    private OrderingService() {};

    private static OrderingService instance ;
    public static OrderingService getInstance() {
        if (instance == null) instance = new OrderingService();
        return instance;
    }

    private RestaurantServie restaurantServie = RestaurantServie.getInstance();
    private UniqueId uniqueId = new UniqueId();


    @Override
    public void placeOrder(String name, int quantity) {
        Restaurant restaurant = restaurantServie.hasRestaurant(name);
        if (restaurant == null) {
            System.out.println("no restaurant exist");
            return ;
        }

        if (restaurant.getFoodItem().getQuantity() < quantity) {
            System.out.println("not enough quantity");
            return ;
        }

        restaurant.getFoodItem().decreaseQuantity(quantity) ;

        int orderID = uniqueId.getId();

        Order order = new Order(orderID, name, quantity, quantity * restaurant.getFoodItem().getPrice())  ;

        System.out.println("order placed successfully" );
        return ;


    }
}

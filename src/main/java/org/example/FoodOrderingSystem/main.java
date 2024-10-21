package org.example.FoodOrderingSystem;


import org.example.FoodOrderingSystem.Entity.MenuItem;
import org.example.FoodOrderingSystem.Entity.OrderItem;
import org.example.FoodOrderingSystem.Helpers.ServiceFactory;
import org.example.FoodOrderingSystem.Interface.IOrderingService;
import org.example.FoodOrderingSystem.Interface.IRestaurantService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        IRestaurantService restaurantService = ServiceFactory.getRestaurantServiceForUser();

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy-hh:mm:ss");
//        LocalDateTime date = LocalDateTime.parse("24/11/1999-10:50:33", formatter);
//        System.out.println(date);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm:ss");
        LocalDateTime date = LocalDateTime.parse("24/11/2999-10:50:33", formatter);
        System.out.println(date);
        boolean fl = LocalDateTime.now().isBefore(date);
        System.out.println(fl);

        List<MenuItem> menu1 = new ArrayList<>();
        menu1.add(new MenuItem("FarmHouse1", 300));
        menu1.add(new MenuItem("FarmHouse2", 200));
        menu1.add(new MenuItem("FarmHouse10", 400));
        restaurantService.addRestaurant("Dominoz", 4.0, 1, menu1);

        List<MenuItem> menu2 = new ArrayList<>();
        menu2.add(new MenuItem("FarmHouse1", 200));
        menu2.add(new MenuItem("FarmHouse2", 400));
        menu2.add(new MenuItem("FarmHouse3", 100));
        restaurantService.addRestaurant("PizzaHut", 3.0, 3, menu2);

        restaurantService.updateMenuItem("PizzaHut", new MenuItem("FarmHouse1", 350));
        restaurantService.updateMenuItem("PizzaHut2", new MenuItem("FarmHouse1", 350));  // Non-existent restaurant
        restaurantService.updateMenuItem("PizzaHut", new MenuItem("FarmHouse1", 350));
        restaurantService.addMenuItem("Dominoz", new MenuItem("FarmHouse7", 350));

        IOrderingService orderService = ServiceFactory.getOrderingServiceForUser();
        List<OrderItem> order = new ArrayList<>();
        order.add(new OrderItem("FarmHouse1", 2));
        order.add(new OrderItem("FarmHouse2", 2));
        order.add(new OrderItem("FarmHouse10", 2));

        String uid = orderService.placeOrder("Ajay", order, "LowestPrice");
        String uid1 = orderService.placeOrder("Ajay2", order, "LowestPrice");
        orderService.updateOrderStatus(uid);
    }
}

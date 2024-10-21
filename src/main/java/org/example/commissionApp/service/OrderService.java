package org.example.commissionApp.service;

import org.example.commissionApp.models.Affliate;
import org.example.commissionApp.models.Commission;
import org.example.commissionApp.models.Order;
import org.example.commissionApp.models.OrderState;

import java.util.HashMap;

public class OrderService {

    private HashMap<Integer, Order> orders ;
    private AffliateService affliateService;
    public OrderService() {
        orders = new HashMap<>();
        affliateService = AffliateService.createAffliateService();
    }

    public void placeOrder(int id, int affliateId, double price, Commission commission, OrderState orderState){
        orders.put(id, new Order(id, affliateId, price, commission, orderState)) ;
        affliateService.updatePendingAmount(commission.calculateCommision(price), affliateId);
        System.out.println("Order successfully created...");
    }

    public void orderStatusChanged (int oderid , String status ) {
        Order order = orders.get(oderid) ;
        if (status == "RETURN_PERIOD_EXPIRED") {
            affliateService.updatePaidAmount(order.getPrice(),order.getAffliateId());
            order.setOrderState(OrderState.RETURN_PERIOD_EXPIRED);
        }
        else {
            order.setOrderState(OrderState.DISPATCHED);
        }
    }




}

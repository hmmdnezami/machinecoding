package org.example.commissionApp;

import org.example.commissionApp.models.Commission;
import org.example.commissionApp.models.ElectronicCommission;
import org.example.commissionApp.models.Order;
import org.example.commissionApp.models.OrderState;
import org.example.commissionApp.service.AffliateService;
import org.example.commissionApp.service.OrderService;

public class main {
    public static void main(String[] args) throws InterruptedException {

        Commission commission = new ElectronicCommission() ;
//        int id, int affliateId, double price, Commission commission, OrderState orderState


        OrderService orderService = new OrderService();
        AffliateService affliateService = AffliateService.createAffliateService();
        affliateService.onboardAffliate(1);
//        Thread.sleep(2000);
        orderService.placeOrder(1, 1, 20.0, commission, OrderState.CREATED);

        affliateService.onboardAffliate(2);
        orderService.placeOrder(1, 2, 20.0, commission, OrderState.CREATED);

    }
}

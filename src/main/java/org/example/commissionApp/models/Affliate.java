package org.example.commissionApp.models;

import java.util.ArrayList;
import java.util.List;

public class Affliate {
    private  int id ;
    private List<Order> orderList ;
    private double pendingAmount ;
    private double paidAmount ;

    public int getId() {
        return id;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public double getPendingAmount() {
        return pendingAmount;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public Affliate(int id) {
        this.id = id;
        this.orderList = new ArrayList<>();
        this.pendingAmount = 0;
        this.paidAmount = 0;
    }

    public void setPendingAmount(double pendingAmount) {
        this.pendingAmount += pendingAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount += paidAmount;
    }
}

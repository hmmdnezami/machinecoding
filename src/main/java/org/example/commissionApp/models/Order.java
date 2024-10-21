package org.example.commissionApp.models;

public class Order {
    private int id ;
    private int affliateId;
    private double price ;
    private Commission commission ;
    private OrderState orderState;

    public int getId() {
        return id;
    }

    public int getAffliateId() {
        return affliateId;
    }

    public double getPrice() {
        return price;
    }

    public Commission getCommission() {
        return commission;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public Order(int id, int affliateId, double price, Commission commission, OrderState orderState) {
        this.id = id;
        this.affliateId = affliateId;
        this.price = price;
        this.commission = commission;
        this.orderState = orderState;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAffliateId(int affliateId) {
        this.affliateId = affliateId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCommission(Commission commission) {
        this.commission = commission;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }
}

package org.example.commissionApp.models;

public class ElectronicCommission implements Commission{
    @Override
    public double calculateCommision(double price) {
        return 0.05 * price;
    }
}

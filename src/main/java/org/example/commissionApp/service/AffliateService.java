package org.example.commissionApp.service;

import org.example.commissionApp.models.Affliate;

import java.util.HashMap;

public class AffliateService {

    private HashMap<Integer, Affliate> affiliatList=  new HashMap<>();;

    private static AffliateService affliateService= null ;

    private AffliateService() {
    }

    public static AffliateService createAffliateService () {
        if (affliateService == null) {
            affliateService = new AffliateService();
        }
        return affliateService;
    }



    public void onboardAffliate(int id) {
        Affliate affliate = new Affliate(id);
        affiliatList.put(id, affliate) ;
        System.out.println("Affiliate with ID " + id + " onboarded.");
    }

    public Affliate getAffliatwById(int id) {
        return affiliatList.get(id) ;
    }

    public void updatePendingAmount(double amount, int id) {
        Affliate affliate = affiliatList.get(id) ;
        affliate.setPendingAmount(amount);
    }

    public void updatePaidAmount(double amount , int id) {
        Affliate affliate = affiliatList.get(id) ;
        affliate.setPendingAmount(-amount);
        affliate.setPaidAmount(amount);
    }
}

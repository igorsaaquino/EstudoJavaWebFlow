package com.igoralencardev.services;

public class BrazilTaxService extends TaxService{

    @Override
    public double tax(double amount){
        return amount * 0.2;
    }
}

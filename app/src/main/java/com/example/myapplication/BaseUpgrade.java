package com.example.myapplication;

public class BaseUpgrade {
    private double basePrice;
    private double multiplier;
    private int count;

    public BaseUpgrade(double basePrice, double multiplier, int count) {
        this.basePrice = basePrice;
        this.multiplier = multiplier;
        this.count = count;
    }

    public void inc(){
        double price = getPrice();

        Storage.getStorage().score -= price;
        count++;
    }

    public double getPrice(){
        return basePrice * Math.pow(multiplier, count);
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

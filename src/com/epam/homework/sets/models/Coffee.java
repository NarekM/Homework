package com.epam.homework.sets.models;

public class Coffee implements Comparable<Coffee> {
    private CoffeeType type;
    private double price;

    public Coffee(CoffeeType type, double price) {
        this.type = type;
        this.price = price;
    }

    public CoffeeType getType() {
        return type;
    }

    public void setType(CoffeeType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Coffee coffee) {
        double diff = this.price - coffee.price;
        return diff > 0 ? 1 : diff < 0 ? -1 : 0;
    }

    @Override
    public String toString() {
        return type + ": " + price;
    }
}

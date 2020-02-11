package com.epam.homework.sets.models;

public class Glasses implements Comparable<Glasses> {
    private GlassesType glassesType;
    private double price;

    public Glasses(GlassesType glassesType, double price) {
        this.glassesType = glassesType;
        this.price = price;
    }

    public GlassesType getGlassesType() {
        return glassesType;
    }

    public void setGlassesType(GlassesType glassesType) {
        this.glassesType = glassesType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Glasses glasses) {
        double diff = this.price - glasses.price;
        return diff > 0 ? 1 : diff < 0 ? -1 : 0;
    }

    @Override
    public String toString() {
        return glassesType + ": "+ price;
    }
}

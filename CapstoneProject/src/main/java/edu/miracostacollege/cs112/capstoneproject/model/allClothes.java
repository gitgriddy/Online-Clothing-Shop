package edu.miracostacollege.cs112.capstoneproject.model;

import java.io.Serializable;
import java.util.Objects;

public abstract class allClothes implements Serializable, Comparable<allClothes>{

    protected String style;
    protected double price;

    public allClothes(String style, double price) {
        this.style = style;
        this.price = price;
    }


    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        allClothes that = (allClothes) o;
        return Double.compare(price, that.price) == 0 && Objects.equals(style, that.style);
    }

    @Override
    public int hashCode() {
        return Objects.hash(style, price);
    }
}

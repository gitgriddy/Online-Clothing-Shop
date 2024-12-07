package edu.miracostacollege.cs112.capstoneproject.model;


import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Objects;


public class Hat extends allClothes implements Serializable, Comparable<allClothes> {
    // TODO: Ensure the class is Serializable so it may be written to a binary file.
    // TODO: Ensure the class implements Comparable, so that Vehicles may be sorted
    // TODO: by year, then by make, then by model.
    private String style;
    private double price;

    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    public static final DecimalFormat noDP = new DecimalFormat("0");

    public Hat(String style, double price) {
        super(style, price);
        this.style = style;
        this.price = price;
    }

    @Override
    public String getStyle() {
        return style;
    }

    @Override
    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Hat hat = (Hat) o;
        return Double.compare(price, hat.price) == 0 && Objects.equals(style, hat.style);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), style, price);
    }

    @Override
    public String toString() {
        return "Hat[" +
                "Style = " + style +
                ", Price = $" + price +
                ']';
    }

    public int compareTo(Hat other) {
        // sorted first by year, then
        // by make, and finally by model
        int styleComp = this.style.compareTo(other.style);
        if (styleComp != 0) return styleComp;

        return (int) (this.price - other.price);

    }

    @Override
    public int compareTo(allClothes o) {
        return 0;
    }
}
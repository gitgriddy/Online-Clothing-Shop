package edu.miracostacollege.cs112.capstoneproject.model;




import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Objects;




public class Pants extends allClothes implements Serializable, Comparable<allClothes> {
   // TODO: Ensure the class is Serializable so it may be written to a binary file.
   // TODO: Ensure the class implements Comparable, so that Vehicles may be sorted
   // TODO: by year, then by make, then by model.
   private String size;
   private String style;
   private double price;


   private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
   public static final DecimalFormat noDP = new DecimalFormat("0");


   public Pants(String size, String style, double price) {
       super(style, price);
       this.style = style;
       this.size = size;
       this.price = price;
   }


   public String getSize() {
       return size;
   }


   public void setSize(String size) {
       this.size = size;
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
   public boolean equals(Object o) {
       if (this == o) return true;
       if (o == null || getClass() != o.getClass()) return false;
       if (!super.equals(o)) return false;
       Pants pants = (Pants) o;
       return Double.compare(price, pants.price) == 0 && Objects.equals(size, pants.size) && Objects.equals(style, pants.style);
   }


   @Override
   public int hashCode() {
       return Objects.hash(super.hashCode(), size, style, price);
   }


   @Override
   public void setPrice(double price) {
       this.price = price;




   }


   @Override
   public String toString() {
       return "Pants[" +
               "Style = " + style +
               ", Size = " + size +
               ", Price = $" + price +
               ']';
   }






   public int compareTo(Pants other) {
       // sorted first by year, then
       // by make, and finally by model
       int styleComp = this.style.compareTo(other.style);
       if (styleComp != 0) return styleComp;




       int sizeComp = this.size.compareTo(other.size);
       if (sizeComp != 0) return sizeComp;




       return (int) (this.price - other.price);


   }


   @Override
   public int compareTo(allClothes o) {
       return 0;
   }
}

package model;

import com.google.gson.annotations.SerializedName;

public class Bid {
    @SerializedName("px")
    private double price;
    @SerializedName("qty")
    private double quantity;
    private double num;

    public Bid(double price, double quantity, double num) {
        this.price = price;
        this.quantity = quantity;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "price='" + price + '\'' +
                ", quantity='" + quantity + '\'' +
                ", num='" + num + '\'' +
                '}';
    }

    public double getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getNum() {
        return num;
    }
}

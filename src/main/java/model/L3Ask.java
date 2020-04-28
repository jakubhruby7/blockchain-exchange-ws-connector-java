package model;

import com.google.gson.annotations.SerializedName;

public class L3Ask {
    @SerializedName("px")
    private double price;
    @SerializedName("qty")
    private double quantity;
    private String id;

    public L3Ask(double price, double quantity, String id) {
        this.price = price;
        this.quantity = quantity;
        this.id = id;
    }

    @Override
    public String toString() {
        return "L3Ask{" +
                "price='" + price + '\'' +
                ", quantity='" + quantity + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public double getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getId() {
        return id;
    }
}

package com.blockchain.bcx.model;

import com.google.gson.annotations.SerializedName;

public class L3Ask {
    @SerializedName("px")
    private String price;
    @SerializedName("qty")
    private String quantity;
    private String id;

    public L3Ask(String price, String quantity, String id) {
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

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getId() {
        return id;
    }
}

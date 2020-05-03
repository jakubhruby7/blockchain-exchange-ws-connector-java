package com.blockchain.bcx.model;

import com.google.gson.annotations.SerializedName;

public class Bid {
    @SerializedName("px")
    private String price;
    @SerializedName("qty")
    private String quantity;
    private String num;

    public Bid(String price, String quantity, String num) {
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

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getNum() {
        return num;
    }
}

package model;

import com.google.gson.annotations.SerializedName;

public class Ask {
    @SerializedName("px")
    private String price;
    @SerializedName("qty")
    private String quantity;
    private String num;

    public Ask(String price, String quantity, String num) {
        this.price = price;
        this.quantity = quantity;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Ask{" +
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

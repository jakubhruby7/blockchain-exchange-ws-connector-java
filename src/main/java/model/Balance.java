package model;

import com.google.gson.annotations.SerializedName;

public class Balance {
    private String currency;
    private double balance;
    private double available;
    @SerializedName("balance_local")
    private double balanceLocal;
    @SerializedName("available_local")
    private double availableLocal;
    private double rate;

    public String getCurrency() {
        return currency;
    }

    public double getBalance() {
        return balance;
    }

    public double getAvailable() {
        return available;
    }

    public double getBalanceLocal() {
        return balanceLocal;
    }

    public double getAvailableLocal() {
        return availableLocal;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "currency='" + currency + '\'' +
                ", balance=" + balance +
                ", available=" + available +
                ", balanceLocal=" + balanceLocal +
                ", availableLocal=" + availableLocal +
                ", rate=" + rate +
                '}';
    }
}

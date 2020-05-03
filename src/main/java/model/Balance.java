package model;

import com.google.gson.annotations.SerializedName;

public class Balance {
    private String currency;
    private String balance;
    private String available;
    @SerializedName("balance_local")
    private String balanceLocal;
    @SerializedName("available_local")
    private String availableLocal;
    private String rate;

    public String getCurrency() {
        return currency;
    }

    public String getBalance() {
        return balance;
    }

    public String getAvailable() {
        return available;
    }

    public String getBalanceLocal() {
        return balanceLocal;
    }

    public String getAvailableLocal() {
        return availableLocal;
    }

    public String getRate() {
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

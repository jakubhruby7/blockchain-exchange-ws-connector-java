package com.blockchain.bcx.model;

import com.google.gson.annotations.SerializedName;

public class Symbol {
    @SerializedName("base_currency")
    private String baseCurrency;
    @SerializedName("base_currency_scale")
    private int baseCurrencyScale;
    @SerializedName("counter_currency")
    private String counterCurrency;
    @SerializedName("counter_currency_scale")
    private int counterCurrencyScale;
    @SerializedName("min_price_increment")
    private int minPriceIncrement;
    @SerializedName("min_price_increment_scale")
    private int minPriceIncrementScale;
    @SerializedName("min_order_size")
    private int minOrderSize;
    @SerializedName("min_order_size_scale")
    private int minOrderSizeScale;
    @SerializedName("max_order_size")
    private int maxOrderSize;
    @SerializedName("max_order_size_scale")
    private int maxOrderSizeScale;
    @SerializedName("lot_size")
    private int lotSize;
    @SerializedName("lot_size_scale")
    private int lotSizeScale;
    @SerializedName("status")
    private String status;
    @SerializedName("id")
    private int id;
    @SerializedName("auction_price")
    private String auctionPrice;
    @SerializedName("auction_size")
    private String auctionSize;
    @SerializedName("auction_time")
    private String auctionTime;
    @SerializedName("imbalance")
    private String imbalance;

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public int getBaseCurrencyScale() {
        return baseCurrencyScale;
    }

    public String getCounterCurrency() {
        return counterCurrency;
    }

    public int getCounterCurrencyScale() {
        return counterCurrencyScale;
    }

    public int getMinPriceIncrement() {
        return minPriceIncrement;
    }

    public int getMinPriceIncrementScale() {
        return minPriceIncrementScale;
    }

    public int getMinOrderSize() {
        return minOrderSize;
    }

    public int getMinOrderSizeScale() {
        return minOrderSizeScale;
    }

    public int getMaxOrderSize() {
        return maxOrderSize;
    }

    public int getMaxOrderSizeScale() {
        return maxOrderSizeScale;
    }

    public int getLotSize() {
        return lotSize;
    }

    public int getLotSizeScale() {
        return lotSizeScale;
    }

    public String getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public String getAuctionPrice() {
        return auctionPrice;
    }

    public String getAuctionSize() {
        return auctionSize;
    }

    public String getAuctionTime() {
        return auctionTime;
    }

    public String getImbalance() {
        return imbalance;
    }
}

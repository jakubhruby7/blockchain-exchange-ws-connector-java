package com.blockchain.bcx.model;

import com.google.gson.annotations.SerializedName;

public enum Channel {
    @SerializedName("heartbeat")
    HEARTBEAT,
    @SerializedName("l2")
    L2,
    @SerializedName("l3")
    L3,
    @SerializedName("prices")
    PRICES,
    @SerializedName("symbols")
    SYMBOLS,
    @SerializedName("ticker")
    TICKER,
    @SerializedName("trades")
    TRADES,
    @SerializedName("auth")
    AUTH,
    @SerializedName("balances")
    BALANCES,
    @SerializedName("trading")
    TRADING
}

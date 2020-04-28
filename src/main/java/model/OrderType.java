package model;

import com.google.gson.annotations.SerializedName;

public enum OrderType {
    @SerializedName("limit")
    LIMIT,
    @SerializedName("market")
    MARKET
}

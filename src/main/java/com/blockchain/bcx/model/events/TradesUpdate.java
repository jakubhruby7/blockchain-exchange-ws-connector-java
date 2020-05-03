package com.blockchain.bcx.model.events;

import com.google.gson.annotations.SerializedName;
import com.blockchain.bcx.model.Side;

public class TradesUpdate extends Event {
    private String symbol;
    private String timestamp;
    private Side side;
    @SerializedName("qty")
    private String quantity;
    private String price;
    @SerializedName("trade_id")
    private String tradeId;

    public TradesUpdate(String seqnum, String event, String channel) {
        super(seqnum, event, channel);
    }

    public String getSymbol() {
        return symbol;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public Side getSide() {
        return side;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getPrice() {
        return price;
    }

    public String getTradeId() {
        return tradeId;
    }

    @Override
    public String toString() {
        return "TradesUpdate{" +
                "symbol='" + symbol + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", side=" + side +
                ", quantity=" + quantity +
                ", price=" + price +
                ", tradeId='" + tradeId + '\'' +
                '}';
    }
}

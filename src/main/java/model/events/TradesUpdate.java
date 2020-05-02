package model.events;

import com.google.gson.annotations.SerializedName;
import model.Side;

public class TradesUpdate extends Event {
    private String symbol;
    private String timestamp;
    private Side side;
    @SerializedName("qty")
    private double quantity;
    private double price;
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

    public double getQuantity() {
        return quantity;
    }

    public double getPrice() {
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

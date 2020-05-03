package model.events;

import com.google.gson.annotations.SerializedName;
import model.Symbol;

import java.util.Map;

public class TickerSnapshot extends Event {
    private String symbol;
    @SerializedName("price_24h")
    private String prices24h;
    @SerializedName("volume_24h")
    private String volume24h;
    @SerializedName("last_trade_price")
    private String lastTradePrice;

    public TickerSnapshot(String seqnum, String event, String channel) {
        super(seqnum, event, channel);
    }

    public String getSymbol() {
        return symbol;
    }

    public String getPrices24h() {
        return prices24h;
    }

    public String getVolume24h() {
        return volume24h;
    }

    public String getLastTradePrice() {
        return lastTradePrice;
    }

    @Override
    public String toString() {
        return "TickerSnapshot{" +
                "symbol='" + symbol + '\'' +
                ", prices24h=" + prices24h +
                ", volume24h=" + volume24h +
                ", lastTradePrice=" + lastTradePrice +
                '}';
    }
}

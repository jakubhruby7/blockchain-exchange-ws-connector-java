package model.events;

import com.google.gson.annotations.SerializedName;
import model.OrderType;
import model.Side;
import model.TimeInForce;

public class TradingRejected extends TradingEvent {

    private String text;
    @SerializedName("clOrdID")
    private String clientOrderId;
    private String ordStatus;
    private String action;

    public TradingRejected(String seqnum, String event, String channel) {
        super(seqnum, event, channel);
    }

    public String getText() {
        return text;
    }

    public String getClientOrderId() {
        return clientOrderId;
    }

    public String getOrdStatus() {
        return ordStatus;
    }

    public String getAction() {
        return action;
    }

    @Override
    public String toString() {
        return "TradingRejected{" +
                "text='" + text + '\'' +
                ", clientOrderId='" + clientOrderId + '\'' +
                ", ordStatus='" + ordStatus + '\'' +
                ", action='" + action + '\'' +
                '}';
    }
}

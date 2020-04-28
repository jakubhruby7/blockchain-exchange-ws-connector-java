package model.events;

import com.google.gson.annotations.SerializedName;
import model.OrderType;
import model.Side;
import model.TimeInForce;

public class TradingUpdate extends Event {

    @SerializedName("orderID")
    private String orderId;
    @SerializedName("clOrdID")
    private String clientOrderId;
    private String symbol;
    private Side side;
    @SerializedName("ordType")
    private OrderType orderType;
    private double orderQty;
    private double leavesQty;
    private double cumQty;
    private double avgPx;
    private String ordStatus;
    private TimeInForce timeInForce;
    private String text;
    private String execType;
    @SerializedName("execID")
    private String execId;
    private String transactTime;
    private int msgType;
    private double lastPx;
    private double lastShares;
    private String tradeId;
    private double price;

    public TradingUpdate(String seqnum, String event, String channel, String orderId, String clientOrderId, String symbol) {
        super(seqnum, event, channel);
        this.orderId = orderId;
        this.clientOrderId = clientOrderId;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "TradingUpdate{" +
                "seqnum='" + seqnum + '\'' +
                ", event='" + event + '\'' +
                ", channel='" + channel + '\'' +
                ", orderId='" + orderId + '\'' +
                ", clientOrderId='" + clientOrderId + '\'' +
                ", symbol='" + symbol + '\'' +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public String getClientOrderId() {
        return clientOrderId;
    }

    public String getSymbol() {
        return symbol;
    }

    public Side getSide() {
        return side;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public double getOrderQty() {
        return orderQty;
    }

    public double getLeavesQty() {
        return leavesQty;
    }

    public double getCumQty() {
        return cumQty;
    }

    public double getAvgPx() {
        return avgPx;
    }

    public String getOrdStatus() {
        return ordStatus;
    }

    public TimeInForce getTimeInForce() {
        return timeInForce;
    }

    public String getText() {
        return text;
    }

    public String getExecType() {
        return execType;
    }

    public String getExecId() {
        return execId;
    }

    public String getTransactTime() {
        return transactTime;
    }

    public int getMsgType() {
        return msgType;
    }

    public double getLastPx() {
        return lastPx;
    }

    public double getLastShares() {
        return lastShares;
    }

    public String getTradeId() {
        return tradeId;
    }

    public double getPrice() {
        return price;
    }
}

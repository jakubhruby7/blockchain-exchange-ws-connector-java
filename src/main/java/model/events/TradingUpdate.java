package model.events;

import com.google.gson.annotations.SerializedName;
import model.OrderType;
import model.Side;
import model.TimeInForce;

public class TradingUpdate extends TradingEvent {

    @SerializedName("orderID")
    private String orderId;
    @SerializedName("clOrdID")
    private String clientOrderId;
    private String symbol;
    private Side side;
    @SerializedName("ordType")
    private OrderType orderType;
    private String orderQty;
    private String leavesQty;
    private String cumQty;
    private String avgPx;
    private String ordStatus;
    private TimeInForce timeInForce;
    private String text;
    private String execType;
    @SerializedName("execID")
    private String execId;
    private String transactTime;
    private int msgType;
    private String lastPx;
    private String lastShares;
    private String tradeId;
    private String price;

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

    public String getOrderQty() {
        return orderQty;
    }

    public String getLeavesQty() {
        return leavesQty;
    }

    public String getCumQty() {
        return cumQty;
    }

    public String getAvgPx() {
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

    public String getLastPx() {
        return lastPx;
    }

    public String getLastShares() {
        return lastShares;
    }

    public String getTradeId() {
        return tradeId;
    }

    public String getPrice() {
        return price;
    }
}

package model;

import com.google.gson.annotations.SerializedName;

public class Order {
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

    public Order(String orderId, String clientOrderId, String symbol, Side side, OrderType orderType, double orderQty, double leavesQty, double cumQty, double avgPx, String ordStatus, TimeInForce timeInForce, String text, String execType, String execId, String transactTime, int msgType, double lastPx, double lastShares, String tradeId, double price) {
        this.orderId = orderId;
        this.clientOrderId = clientOrderId;
        this.symbol = symbol;
        this.side = side;
        this.orderType = orderType;
        this.orderQty = orderQty;
        this.leavesQty = leavesQty;
        this.cumQty = cumQty;
        this.avgPx = avgPx;
        this.ordStatus = ordStatus;
        this.timeInForce = timeInForce;
        this.text = text;
        this.execType = execType;
        this.execId = execId;
        this.transactTime = transactTime;
        this.msgType = msgType;
        this.lastPx = lastPx;
        this.lastShares = lastShares;
        this.tradeId = tradeId;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", clientOrderId='" + clientOrderId + '\'' +
                ", symbol='" + symbol + '\'' +
                ", side=" + side +
                ", orderType=" + orderType +
                ", orderQty=" + orderQty +
                ", leavesQty=" + leavesQty +
                ", cumQty=" + cumQty +
                ", avgPx=" + avgPx +
                ", ordStatus='" + ordStatus + '\'' +
                ", timeInForce=" + timeInForce +
                ", text='" + text + '\'' +
                ", execType='" + execType + '\'' +
                ", execId='" + execId + '\'' +
                ", transactTime='" + transactTime + '\'' +
                ", msgType=" + msgType +
                ", lastPx=" + lastPx +
                ", lastShares=" + lastShares +
                ", tradeId='" + tradeId + '\'' +
                ", price=" + price +
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

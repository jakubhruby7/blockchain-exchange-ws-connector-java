package com.blockchain.bcx.model;

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

    public Order(String orderId, String clientOrderId, String symbol, Side side, OrderType orderType, String orderQty, String leavesQty, String cumQty, String avgPx, String ordStatus, TimeInForce timeInForce, String text, String execType, String execId, String transactTime, int msgType, String lastPx, String lastShares, String tradeId, String price) {
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
}

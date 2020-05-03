package com.blockchain.bcx.model.events;

public class SubscribedPrices extends Subscribed {

    private String symbol;

    public SubscribedPrices(String seqnum, String event, String channel, String symbol) {
        super(seqnum, event, channel);
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "SubscribedPrices{" +
                "symbol='" + symbol + '\'' +
                ", seqnum='" + seqnum + '\'' +
                ", event='" + event + '\'' +
                ", channel='" + channel + '\'' +
                '}';
    }

    public String getSymbol() {
        return symbol;
    }
}

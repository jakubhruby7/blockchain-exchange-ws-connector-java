package com.blockchain.bcx.model.events;

public class SubscribedL2 extends Subscribed {

    private String symbol;

    public SubscribedL2(String seqnum, String event, String channel, String symbol) {
        super(seqnum, event, channel);
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "SubscribedL2{" +
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

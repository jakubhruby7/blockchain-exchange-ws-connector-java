package com.blockchain.bcx.model.events;

import java.util.Arrays;

public class PricesUpdate extends Event {
    private String symbol;
    private String[] price;

    public PricesUpdate(String seqnum, String event, String channel, String symbol, String[] price) {
        super(seqnum, event, channel);
        this.symbol = symbol;
        this.price = price;
    }

    @Override
    public String toString() {
        return "PricesUpdate{" +
                "symbol='" + symbol + '\'' +
                ", price=" + Arrays.toString(price) +
                ", seqnum='" + seqnum + '\'' +
                ", event='" + event + '\'' +
                ", channel='" + channel + '\'' +
                '}';
    }

    public String[] getPrice() {
        return price;
    }
}

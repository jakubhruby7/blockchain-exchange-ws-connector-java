package com.blockchain.bcx.model.actions;

import com.blockchain.bcx.model.Channel;

public class SubscribePrices extends Subscribe {
    private String symbol;
    private int granularity;

    public SubscribePrices(String symbol, int granularity) {
        super(Channel.PRICES);
        this.symbol = symbol;
        this.granularity = granularity;
    }
}

package com.blockchain.bcx.model.actions;

import com.blockchain.bcx.model.Channel;

public class SubscribeTrades extends Subscribe {
    private String symbol;

    public SubscribeTrades(String symbol) {
        super(Channel.TRADES);
        this.symbol = symbol;
    }
}

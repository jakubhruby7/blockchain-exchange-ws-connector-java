package com.blockchain.bcx.model.actions;

import com.blockchain.bcx.model.Channel;

public class SubscribeTicker extends Subscribe {
    private String symbol;

    public SubscribeTicker(String symbol) {
        super(Channel.TICKER);
        this.symbol = symbol;
    }
}

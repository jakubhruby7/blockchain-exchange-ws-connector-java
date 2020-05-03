package com.blockchain.bcx.model.actions;

import com.blockchain.bcx.model.Channel;

public class SubscribeL2 extends Subscribe {
    private String symbol;

    public SubscribeL2(String symbol) {
        super(Channel.L2);
        this.symbol = symbol;
    }
}

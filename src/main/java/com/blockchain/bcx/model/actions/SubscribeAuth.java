package com.blockchain.bcx.model.actions;

import com.blockchain.bcx.model.Channel;

public class SubscribeAuth extends Subscribe {
    private String token;

    public SubscribeAuth(String token) {
        super(Channel.AUTH);
        this.token = token;
    }
}

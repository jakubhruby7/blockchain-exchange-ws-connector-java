package com.blockchain.bcx.model.actions;

import com.blockchain.bcx.model.Channel;

public class Subscribe extends Action {

    public Subscribe(Channel channel) {
        this.action = ActionType.SUBSCRIBE;
        this.channel = channel;
    }
}

package com.blockchain.bcx.model.actions;

import com.blockchain.bcx.model.Channel;

public class BulkCancelAction extends Action {

    public BulkCancelAction() {
        this.action = ActionType.ORDER_MASS_CANCEL_REQUEST;
        this.channel = Channel.TRADING;
    }

    @Override
    public String toString() {
        return "BulkCancelAction{" +
                "action=" + action +
                ", channel=" + channel +
                '}';
    }
}

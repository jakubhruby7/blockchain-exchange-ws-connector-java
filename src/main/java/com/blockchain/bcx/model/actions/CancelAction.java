package com.blockchain.bcx.model.actions;

import com.google.gson.annotations.SerializedName;
import com.blockchain.bcx.model.Channel;

public class CancelAction extends Action {
    @SerializedName("orderID")
    private final String orderId;

    public CancelAction(String orderId) {
        this.orderId = orderId;
        this.action = ActionType.CANCEL_ORDER_REQUEST;
        this.channel = Channel.TRADING;
    }

    @Override
    public String toString() {
        return "CancelAction{" +
                "orderId='" + orderId + '\'' +
                ", action='" + action + '\'' +
                ", channel='" + channel + '\'' +
                '}';
    }
}

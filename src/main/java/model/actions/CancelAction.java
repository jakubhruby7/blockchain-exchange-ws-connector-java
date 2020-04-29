package model.actions;

import com.google.gson.annotations.SerializedName;
import model.Channel;
import model.actions.Action;
import model.actions.ActionType;

public class CancelAction extends Action {
    @SerializedName("orderID")
    private final String orderId;

    public CancelAction(String orderId) {
        this.orderId = orderId;
        this.action = ActionType.CANCEL_ORDER_REQUEST;
        this.channel = Channel.TRADING.name();
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

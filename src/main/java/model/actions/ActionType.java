package model.actions;

import com.google.gson.annotations.SerializedName;

enum ActionType {
    @SerializedName("subscribe")
    SUBSCRIBE,
    @SerializedName("NewOrderSingle")
    NEW_ORDER_SINGLE,
    @SerializedName("CancelOrderRequest")
    CANCEL_ORDER_REQUEST;
}

package model.actions;

import com.google.gson.annotations.SerializedName;
import model.Channel;
import model.OrderType;
import model.Side;
import model.TimeInForce;

public class OrderAction extends Action {

    @SerializedName("clOrdID")
    private final String clientOrderId;
    private final String symbol;
    @SerializedName("ordType")
    private final OrderType orderType;
    private final TimeInForce timeInForce;
    private final Side side;
    private final String orderQty;
    private final String price;
    private final boolean addLiquidityOnly;


    public OrderAction(
            String clientOrderId,
            String symbol,
            OrderType orderType,
            TimeInForce timeInForce,
            Side side,
            String orderQty,
            String price,
            boolean addLiquidityOnly
    ) {
        this.action = ActionType.NEW_ORDER_SINGLE;
        this.channel = Channel.TRADING;
        this.clientOrderId = clientOrderId;
        this.symbol = symbol;
        this.orderType = orderType;
        this.timeInForce = timeInForce;
        this.side = side;
        this.orderQty = orderQty;
        this.price = price;
        this.addLiquidityOnly = addLiquidityOnly;
    }
}

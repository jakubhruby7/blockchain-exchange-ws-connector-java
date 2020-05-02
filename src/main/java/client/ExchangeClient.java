package client;

import handlers.EventHandler;
import handlers.HeartbeatHandler;
import model.OrderType;
import model.Side;
import model.TimeInForce;

public interface ExchangeClient {
    /**
     * Connects to the Exchange
     * @param apiKey API key
     * @return
     */
    boolean connect(String apiKey);

    /**
     * Subscribes to all channels
     */
    void subscribeAll();

    /**
     * Subscribes to all channels
     * @param handler the handler that will be called when the event is received
     */
    void subscribeAll(EventHandler handler);

    /**
     * Subscribes to the heartbeat channel
     */
    void subscribeHeartbeat();

    /**
     * Subscribes to the heartbeat channel
     * @param handler the heartbeat handler that will be called when the heartbeat event is received
     */
    void subscribeHeartbeat(HeartbeatHandler handler);

    /**
     * Handles heartbeat events
     * @param handler the heartbeat handler that will be called when the heartbeat event is received
     */
    void onHeartbeat(HeartbeatHandler handler);

    /**
     * Creates a new order
     * @param clientOrderId
     * @param symbol
     * @param orderType
     * @param timeInForce
     * @param side
     * @param orderQty
     * @param price
     * @param addLiquidityOnly
     */
    void createOrder(
            String clientOrderId,
            String symbol,
            OrderType orderType,
            TimeInForce timeInForce,
            Side side,
            double  orderQty,
            double price,
            boolean addLiquidityOnly
    );

    /**
     * Cancels an order
     * @param orderId
     */
    void cancelOrder(String orderId);
}

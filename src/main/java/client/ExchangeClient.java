package client;

import handlers.EventHandler;
import handlers.HeartbeatHandler;
import handlers.L2Handler;
import handlers.L3Handler;
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
     * Handles events
     * @param handler the event handler that will be called when the new event is received
     */
    void onEvent(EventHandler handler);

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
     * Subscribes to the l2 channel
     * @param symbol the trading pair
     */
    void subscribeL2(String symbol);

    /**
     * Subscribes to the l2 channel
     * @param symbol the trading pair
     * @param handler the l2 handler that will be called when the l2 event is received
     */
    void subscribeL2(String symbol, L2Handler handler);

    /**
     * Handles l2 events
     * @param handler the l2 handler that will be called when the l2 event is received
     */
    void onL2(L2Handler handler);

    /**
     * Subscribes to the l3 channel
     * @param symbol the trading pair
     */
    void subscribeL3(String symbol);

    /**
     * Subscribes to the l3 channel
     * @param symbol the trading pair
     * @param handler the l3 handler that will be called when the l3 event is received
     */
    void subscribeL3(String symbol, L3Handler handler);

    /**
     * Handles l3 events
     * @param handler the l3 handler that will be called when the l3 event is received
     */
    void onL3(L3Handler handler);

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

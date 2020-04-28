package client;

import model.OrderType;
import model.Side;
import model.TimeInForce;

import java.math.BigDecimal;

public interface ExchangeClient {
    /**
     * Connects to the Exchange
     * @param apiKey API key
     * @return
     */
    boolean connect(String apiKey);

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
            BigDecimal orderQty,
            BigDecimal price,
            boolean addLiquidityOnly
    );

    /**
     * Cancels an order
     * @param orderId
     */
    void cancelOrder(String orderId);
}

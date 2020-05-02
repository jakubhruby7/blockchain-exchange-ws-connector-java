package client;

import handlers.*;
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
     * Subscribes to the prices channel
     * @param symbol the trading pair
     * @param granularity the granularity defined in seconds, possible values 60, 300, 900, 3600, 21600, 86400
     */
    void subscribePrices(String symbol, int granularity);

    /**
     * Subscribes to the prices channel
     * @param symbol the trading pair
     * @param granularity the granularity defined in seconds, possible values 60, 300, 900, 3600, 21600, 86400
     * @param handler the prices handler that will be called when the prices event is received
     */
    void subscribePrices(String symbol, int granularity, PricesHandler handler);

    /**
     * Handles prices events
     * @param handler the prices handler that will be called when the prices event is received
     */
    void onPrices(PricesHandler handler);

    /**
     * Subscribes to the symbols channel
     */
    void subscribeSymbols();

    /**
     * Subscribes to the symbols channel
     * @param handler the symbols handler that will be called when the symbols snapshot is received
     */
    void subscribeSymbols(SymbolsHandler handler);

    /**
     * Subscribes to the ticker channel
     * @param symbol the trading pair
     */
    void subscribeTicker(String symbol);

    /**
     * Subscribes to the ticker channel
     * @param symbol the trading pair
     * @param handler the ticker handler that will be called when the ticker snapshot is received
     */
    void subscribeTicker(String symbol, TickerHandler handler);

    /**
     * Subscribes to the trades channel
     * @param symbol the trading pair
     */
    void subscribeTrades(String symbol);

    /**
     * Subscribes to the trades channel
     * @param symbol the trading pair
     * @param handler the trades handler that will be called when the trades event is received
     */
    void subscribeTrades(String symbol, TradesHandler handler);

    /**
     * Handles trades events
     * @param handler the trades handler that will be called when the trades event is received
     */
    void onTrades(TradesHandler handler);

    /**
     * Subscribes to the balances channel
     */
    void subscribeBalances();

    /**
     * Subscribes to the balances channel
     * @param handler the balances handler that will be called when the balances snapshot is received
     */
    void subscribeBalances(BalancesHandler handler);

    /**
     * Handles balances snapshots
     * @param handler the balances handler that will be called when the balances snapshot is received
     */
    void onBalances(BalancesHandler handler);

    /**
     * Subscribes to the trading channel
     */
    void subscribeTrading();

    /**
     * Subscribes to the trading channel
     * @param handler the trading handler that will be called when the trading event is received
     */
    void subscribeTrading(TradingHandler handler);

    /**
     * Subscribes to the trading channel
     * @param snapshotHandler the trading handler that will be called when the trading snapshot is received
     * @param updateHandler the trading handler that will be called when the trading update is received
     * @param rejectHandler the trading handler that will be called when the trading rejection is received
     */
    void subscribeTrading(TradingSnapshotHandler snapshotHandler, TradingUpdateHandler updateHandler, TradingRejectedHandler rejectHandler);

    /**
     * Handles trading events
     * @param handler the trading handler that will be called when the trading event is received
     */
    void onTrading(TradingHandler handler);

    /**
     * Handles trading snapshot events
     * @param handler the trading handler that will be called when the trading snapshot is received
     */
    void onTradingSnapshot(TradingSnapshotHandler handler);

    /**
     * Handles trading update events
     * @param handler the trading handler that will be called when the trading update is received
     */
    void onTradingUpdate(TradingUpdateHandler handler);

    /**
     * Handles trading reject events
     * @param handler the trading handler that will be called when the trading rejection is received
     */
    void onTradingReject(TradingRejectedHandler handler);

    /**
     * Creates a new order
     * @param clientOrderId the client order id
     * @param symbol the trading pair
     * @param orderType the order type LIMIT, MARKET
     * @param timeInForce the time in force, for example GTC
     * @param side the side BUY, SELL
     * @param orderQty the order quantity
     * @param price the order price
     * @param addLiquidityOnly the liquidity only indicator
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
     * @param orderId the order id to be cancelled
     */
    void cancelOrder(String orderId);
}

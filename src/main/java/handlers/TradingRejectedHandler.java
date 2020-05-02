package handlers;

import model.events.TradingRejected;

@FunctionalInterface
public interface TradingRejectedHandler {
    void handle(TradingRejected tradingRejected);
}

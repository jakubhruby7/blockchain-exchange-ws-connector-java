package handlers;

import model.events.TradingUpdate;

@FunctionalInterface
public interface TradingUpdateHandler {
    void handle(TradingUpdate tradingUpdate);
}

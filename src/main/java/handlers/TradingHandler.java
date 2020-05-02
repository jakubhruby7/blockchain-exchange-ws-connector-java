package handlers;

import model.events.TradingEvent;

@FunctionalInterface
public interface TradingHandler {
    void handle(TradingEvent tradingEvent);
}

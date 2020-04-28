package handlers;

import model.events.TradingUpdate;

@FunctionalInterface
public interface OrderUpdateHandler {
    void handle(TradingUpdate event);
}

package handlers;

import model.events.TickerSnapshot;

@FunctionalInterface
public interface TickerHandler {
    void handle(TickerSnapshot tickerSnapshot);
}

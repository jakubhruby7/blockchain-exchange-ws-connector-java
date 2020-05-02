package handlers;

import model.events.TradingSnapshot;

@FunctionalInterface
public interface TradingSnapshotHandler {
    void handle(TradingSnapshot tradingSnapshot);
}

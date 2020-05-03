package com.blockchain.bcx.handlers;

import com.blockchain.bcx.model.events.TickerSnapshot;

@FunctionalInterface
public interface TickerHandler {
    void handle(TickerSnapshot tickerSnapshot);
}

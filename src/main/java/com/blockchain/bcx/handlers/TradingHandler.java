package com.blockchain.bcx.handlers;

import com.blockchain.bcx.model.events.TradingEvent;

@FunctionalInterface
public interface TradingHandler {
    void handle(TradingEvent tradingEvent);
}

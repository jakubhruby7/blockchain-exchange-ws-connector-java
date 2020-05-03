package com.blockchain.bcx.handlers;

import com.blockchain.bcx.model.events.TradingRejected;

@FunctionalInterface
public interface TradingRejectedHandler {
    void handle(TradingRejected tradingRejected);
}

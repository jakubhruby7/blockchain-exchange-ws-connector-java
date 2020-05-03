package com.blockchain.bcx.handlers;

import com.blockchain.bcx.model.events.TradingUpdate;

@FunctionalInterface
public interface TradingUpdateHandler {
    void handle(TradingUpdate tradingUpdate);
}

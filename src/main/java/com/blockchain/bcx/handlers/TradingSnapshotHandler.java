package com.blockchain.bcx.handlers;

import com.blockchain.bcx.model.events.TradingSnapshot;

@FunctionalInterface
public interface TradingSnapshotHandler {
    void handle(TradingSnapshot tradingSnapshot);
}

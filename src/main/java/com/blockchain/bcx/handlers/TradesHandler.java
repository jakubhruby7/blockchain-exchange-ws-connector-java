package com.blockchain.bcx.handlers;

import com.blockchain.bcx.model.events.TradesUpdate;

@FunctionalInterface
public interface TradesHandler {
    void handle(TradesUpdate tradesUpdate);
}

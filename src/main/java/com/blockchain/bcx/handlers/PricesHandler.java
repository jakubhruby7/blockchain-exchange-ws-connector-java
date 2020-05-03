package com.blockchain.bcx.handlers;

import com.blockchain.bcx.model.events.PricesUpdate;

@FunctionalInterface
public interface PricesHandler {
    void handle(PricesUpdate pricesUpdate);
}

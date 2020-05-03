package com.blockchain.bcx.handlers;

import com.blockchain.bcx.model.events.BalancesSnapshot;

@FunctionalInterface
public interface BalancesHandler {
    void handle(BalancesSnapshot balancesSnapshot);
}

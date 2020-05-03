package com.blockchain.bcx.handlers;

import com.blockchain.bcx.model.events.L2;

@FunctionalInterface
public interface L2Handler {
    void handle(L2 l2);
}

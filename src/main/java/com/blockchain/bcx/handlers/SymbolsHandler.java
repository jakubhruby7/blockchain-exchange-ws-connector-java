package com.blockchain.bcx.handlers;

import com.blockchain.bcx.model.events.SymbolsSnapshot;

@FunctionalInterface
public interface SymbolsHandler {
    void handle(SymbolsSnapshot symbolsSnapshot);
}

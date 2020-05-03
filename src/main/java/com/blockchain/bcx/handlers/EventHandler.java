package com.blockchain.bcx.handlers;

import com.blockchain.bcx.model.events.Event;

@FunctionalInterface
public interface EventHandler {
    void handle(Event event);
}

package com.blockchain.bcx.handlers;

import com.blockchain.bcx.model.events.Heartbeat;

@FunctionalInterface
public interface HeartbeatHandler {
    void handle(Heartbeat heartbeat);
}

package handlers;

import model.events.Heartbeat;

@FunctionalInterface
public interface HeartbeatHandler {
    void handle(Heartbeat heartbeat);
}

package handlers;

import model.events.Event;

@FunctionalInterface
public interface EventHandler {
    void handle(Event event);
}

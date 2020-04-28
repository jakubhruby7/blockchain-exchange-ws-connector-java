package handlers;

import model.events.Event;

@FunctionalInterface
public interface  Handler {
    void handle(Event event);
}

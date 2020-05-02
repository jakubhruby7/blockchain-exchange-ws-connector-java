package handlers;

import model.events.L3;

@FunctionalInterface
public interface L3Handler {
    void handle(L3 l3);
}

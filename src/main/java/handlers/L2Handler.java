package handlers;

import model.events.L2;

@FunctionalInterface
public interface L2Handler {
    void handle(L2 l2);
}

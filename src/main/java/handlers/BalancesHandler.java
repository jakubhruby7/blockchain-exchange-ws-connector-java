package handlers;

import model.events.BalancesSnapshot;

@FunctionalInterface
public interface BalancesHandler {
    void handle(BalancesSnapshot balancesSnapshot);
}

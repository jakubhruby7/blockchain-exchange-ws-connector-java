package handlers;

import model.events.TradesUpdate;

@FunctionalInterface
public interface TradesHandler {
    void handle(TradesUpdate tradesUpdate);
}

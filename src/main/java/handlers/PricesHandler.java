package handlers;

import model.events.PricesUpdate;

@FunctionalInterface
public interface PricesHandler {
    void handle(PricesUpdate pricesUpdate);
}

package handlers;

import model.events.SymbolsSnapshot;

@FunctionalInterface
public interface SymbolsHandler {
    void handle(SymbolsSnapshot symbolsSnapshot);
}

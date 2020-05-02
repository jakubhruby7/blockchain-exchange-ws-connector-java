package model.events;

import model.Symbol;

import java.util.Map;

public class SymbolsSnapshot extends Event {
    private Map<String, Symbol> symbols;

    public SymbolsSnapshot(String seqnum, String event, String channel, Map<String, Symbol> symbols) {
        super(seqnum, event, channel);
        this.symbols = symbols;
    }

    public Map<String, Symbol> getSymbols() {
        return symbols;
    }
}

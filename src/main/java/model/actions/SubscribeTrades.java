package model.actions;

import model.Channel;

public class SubscribeTrades extends Subscribe {
    private String symbol;

    public SubscribeTrades(String symbol) {
        super(Channel.TRADES);
        this.symbol = symbol;
    }
}

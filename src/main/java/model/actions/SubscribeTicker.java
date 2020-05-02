package model.actions;

import model.Channel;

public class SubscribeTicker extends Subscribe {
    private String symbol;

    public SubscribeTicker(String symbol) {
        super(Channel.TICKER);
        this.symbol = symbol;
    }
}

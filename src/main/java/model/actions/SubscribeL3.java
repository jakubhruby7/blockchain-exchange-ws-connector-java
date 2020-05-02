package model.actions;

import model.Channel;

public class SubscribeL3 extends Subscribe {
    private String symbol;

    public SubscribeL3(String symbol) {
        super(Channel.L3);
        this.symbol = symbol;
    }
}

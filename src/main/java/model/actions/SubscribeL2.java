package model.actions;

import model.Channel;

public class SubscribeL2 extends Subscribe {
    private String symbol;

    public SubscribeL2(String symbol) {
        super(Channel.L2);
        this.symbol = symbol;
    }
}

package model.actions;

import model.Channel;

public class SubscribePrices extends Subscribe {
    private String symbol;
    private int granularity;

    public SubscribePrices(String symbol, int granularity) {
        super(Channel.PRICES);
        this.symbol = symbol;
        this.granularity = granularity;
    }
}

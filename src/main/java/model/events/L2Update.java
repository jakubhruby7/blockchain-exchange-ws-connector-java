package model.events;

import model.Ask;
import model.Bid;

import java.util.Arrays;

public class L2Update extends Event {
    private String symbol;
    private Bid[] bids;
    private Ask[] asks;

    public L2Update(String seqnum, String event, String channel, String symbol, Bid[] bids, Ask[] asks) {
        super(seqnum, event, channel);
        this.symbol = symbol;
        this.bids = bids;
        this.asks = asks;
    }

    @Override
    public String toString() {
        return "L2Update{" +
                "seqnum='" + seqnum + '\'' +
                ", event='" + event + '\'' +
                ", channel='" + channel + '\'' +
                ", symbol='" + symbol + '\'' +
                ", bids=" + Arrays.toString(bids) +
                ", asks=" + Arrays.toString(asks) +
                '}';
    }

    public String getSymbol() {
        return symbol;
    }

    public Bid[] getBids() {
        return bids;
    }

    public Ask[] getAsks() {
        return asks;
    }
}

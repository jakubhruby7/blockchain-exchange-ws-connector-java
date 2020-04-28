package model.events;

import model.L3Ask;
import model.L3Bid;

import java.util.Arrays;

public class L3Snapshot extends Event {
    private String symbol;
    private L3Bid[] bids;
    private L3Ask[] asks;

    public L3Snapshot(String seqnum, String event, String channel, String symbol, L3Bid[] bids, L3Ask[] asks) {
        super(seqnum, event, channel);
        this.symbol = symbol;
        this.bids = bids;
        this.asks = asks;
    }

    @Override
    public String toString() {
        return "L3Snapshot{" +
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

    public L3Bid[] getBids() {
        return bids;
    }

    public L3Ask[] getAsks() {
        return asks;
    }
}

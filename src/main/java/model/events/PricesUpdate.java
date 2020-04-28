package model.events;

import java.util.Arrays;

public class PricesUpdate extends Event {
    private String symbol;
    private double[] price;

    public PricesUpdate(String seqnum, String event, String channel, String symbol, double[] price) {
        super(seqnum, event, channel);
        this.symbol = symbol;
        this.price = price;
    }

    @Override
    public String toString() {
        return "PricesUpdate{" +
                "symbol='" + symbol + '\'' +
                ", price=" + Arrays.toString(price) +
                ", seqnum='" + seqnum + '\'' +
                ", event='" + event + '\'' +
                ", channel='" + channel + '\'' +
                '}';
    }

    public double[] getPrice() {
        return price;
    }
}

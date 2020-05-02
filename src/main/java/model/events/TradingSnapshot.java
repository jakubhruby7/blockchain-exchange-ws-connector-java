package model.events;

import model.Order;

import java.util.Arrays;

public class TradingSnapshot extends TradingEvent {
    private Order[] orders;

    public TradingSnapshot(String seqnum, String event, String channel, Order[] orders) {
        super(seqnum, event, channel);
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "TradingSnapshot{" +
                "orders=" + Arrays.toString(orders) +
                ", seqnum='" + seqnum + '\'' +
                ", event='" + event + '\'' +
                ", channel='" + channel + '\'' +
                '}';
    }

    public Order[] getOrders() {
        return orders;
    }
}

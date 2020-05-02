package model.events;

public class TradingEvent extends Event {
    public TradingEvent(String seqnum, String event, String channel) {
        super(seqnum, event, channel);
    }
}

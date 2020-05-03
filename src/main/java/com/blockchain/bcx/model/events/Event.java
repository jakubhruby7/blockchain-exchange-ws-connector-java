package com.blockchain.bcx.model.events;

public class Event {
    protected String seqnum;
    protected String event;
    protected String channel;

    public Event(String seqnum, String event, String channel) {
        this.seqnum = seqnum;
        this.event = event;
        this.channel = channel;
    }

    public String getSeqnum() {
        return seqnum;
    }

    public String getEvent() {
        return event;
    }

    public String getChannel() {
        return channel;
    }
}

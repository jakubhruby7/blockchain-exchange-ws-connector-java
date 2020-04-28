package model.events;

public class Heartbeat extends Event {
    private String timestamp;

    public Heartbeat(String seqnum, String event, String channel, String timestamp) {
        super(seqnum, event, channel);
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Heartbeat{" +
                "timestamp='" + timestamp + '\'' +
                ", seqnum='" + seqnum + '\'' +
                ", event='" + event + '\'' +
                ", channel='" + channel + '\'' +
                '}';
    }

    public String getTimestamp() {
        return timestamp;
    }
}

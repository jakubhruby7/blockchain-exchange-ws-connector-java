package model.events;

public class Subscribed extends Event {

    public Subscribed(String seqnum, String event, String channel) {
        super(seqnum, event, channel);
    }

    @Override
    public String toString() {
        return "Subscribed{" +
                "seqnum='" + seqnum + '\'' +
                ", event='" + event + '\'' +
                ", channel='" + channel + '\'' +
                '}';
    }


}

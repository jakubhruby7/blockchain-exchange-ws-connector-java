package decoders;

import com.google.gson.JsonObject;
import model.events.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import static utils.JsonUtils.fromJson;
import static utils.JsonUtils.isJsonValid;

public class EventDecoder implements Decoder.Text<Event> {

    final Logger logger = LoggerFactory.getLogger(EventDecoder.class);

    public static final String EVENT = "event";
    public static final String CHANNEL = "channel";
    public static final String SEQNUM = "seqnum";
    public static final String SYMBOL = "symbol";

    private static class Channel {
        private static final String HEARTBEAT = "heartbeat";
        private static final String L2 = "l2";
        private static final String L3 = "l3";
        private static final String PRICES = "prices";
        private static final String SYMBOLS = "symbols";
        private static final String TICKER = "ticker";
        private static final String TRADES = "trades";
        private static final String AUTH = "auth";
        private static final String BALANCES = "balances";
        private static final String TRADING = "trading";
    }

    private static class EventName {
        private static final String SUBSCRIBED = "subscribed";
        private static final String UNSUBSCRIBED = "unsubscribed";
        private static final String REJECTED = "rejected";
        private static final String SNAPSHOT = "snapshot";
        private static final String UPDATED = "updated";
    }

    @Override
    public Event decode(String s) {
        final JsonObject message = fromJson(s);
        final String event = message.get(EVENT).getAsString();
        final String channel = message.get(CHANNEL).getAsString();
        final String seqnum = message.get(SEQNUM).getAsString();

        if (event.equals(EventName.SUBSCRIBED)) {
            if (channel.equals(Channel.L2)) {
                return fromJson(message, SubscribedL2.class);
            } if (channel.equals(Channel.PRICES)) {
                return fromJson(message, SubscribedPrices.class);
            } else {
                return fromJson(message, Subscribed.class);
            }
        } else if (event.equals(EventName.UPDATED)) {
            if (channel.equals(Channel.HEARTBEAT)) {
                return fromJson(message, Heartbeat.class);
            }
            if (channel.equals(Channel.L2)) {
                return fromJson(message, L2Update.class);
            }
            if (channel.equals(Channel.L3)) {
                return fromJson(message, L3Update.class);
            }
            if (channel.equals(Channel.PRICES)) {
                return fromJson(message, PricesUpdate.class);
            }
            if (channel.equals(Channel.TRADING)) {
                return fromJson(message, TradingUpdate.class);
            }
        } else if (event.equals(EventName.REJECTED)) {
            //TODO handle rejected
        } else if (event.equals(EventName.SNAPSHOT)) {
            if (channel.equals(Channel.L2)) {
                return fromJson(message, L2Snapshot.class);
            }
            if (channel.equals(Channel.L3)) {
                return fromJson(message, L3Snapshot.class);
            }
            if (channel.equals(Channel.TRADING)) {
                return fromJson(message, TradingSnapshot.class);
            }
        } else {
            return new Event(seqnum, event, channel);
        }
        return new Event(seqnum, event, channel);
    }

    @Override
    public boolean willDecode(String s) {
        return isJsonValid(s);
    }

    @Override
    public void init(EndpointConfig config) {
        logger.info("EventDecoder -init method called");
    }

    @Override
    public void destroy() {
        logger.info("EventDecoder - destroy method called");
    }
}

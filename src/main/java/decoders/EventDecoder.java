package decoders;

import com.google.gson.JsonObject;
import model.Channel;
import model.events.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import static utils.JsonUtils.fromJson;
import static utils.JsonUtils.isJsonValid;

public class EventDecoder implements Decoder.Text<Event> {

    final Logger logger = LoggerFactory.getLogger(EventDecoder.class);

    private static final String EVENT = "event";
    private static final String CHANNEL = "channel";
    private static final String SEQNUM = "seqnum";
    private static final String SYMBOL = "symbol";

    private enum EventName {
        SUBSCRIBED,
        UNSUBSCRIBED,
        REJECTED,
        SNAPSHOT,
        UPDATED
    }

    @Override
    public Event decode(String s) {
        final JsonObject message = fromJson(s);
        final EventName event = EventName.valueOf(message.get(EVENT).getAsString().toUpperCase());
        final Channel channel = Channel.valueOf(message.get(CHANNEL).getAsString().toUpperCase());
        final String seqnum = message.get(SEQNUM).getAsString();

        if (event == EventName.SUBSCRIBED) {
            if (channel == Channel.L2) {
                return fromJson(message, SubscribedL2.class);
            } if (channel == Channel.PRICES) {
                return fromJson(message, SubscribedPrices.class);
            } else {
                return fromJson(message, Subscribed.class);
            }
        } else if (event == EventName.UPDATED) {
            if (channel == Channel.HEARTBEAT) {
                return fromJson(message, Heartbeat.class);
            }
            if (channel == Channel.L2) {
                return fromJson(message, L2.class);
            }
            if (channel == Channel.L3) {
                return fromJson(message, L3.class);
            }
            if (channel == Channel.PRICES) {
                return fromJson(message, PricesUpdate.class);
            }
            if (channel == Channel.SYMBOLS) {
                return fromJson(message, SymbolsSnapshot.class);
            }
            if (channel == Channel.TRADES) {
                return fromJson(message, TradesUpdate.class);
            }
            if (channel == Channel.TRADING) {
                return fromJson(message, TradingUpdate.class);
            }
        } else if (event == EventName.REJECTED) {
            if (channel == Channel.TRADING) {
                return fromJson(message, TradingRejected.class);
            }
            logger.info("rejected: " + s);
        } else if (event == EventName.SNAPSHOT) {
            if (channel == Channel.L2) {
                return fromJson(message, L2.class);
            }
            if (channel == Channel.L3) {
                return fromJson(message, L3.class);
            }
            if (channel == Channel.SYMBOLS) {
                return fromJson(message, SymbolsSnapshot.class);
            }
            if (channel == Channel.TICKER) {
                return fromJson(message, TickerSnapshot.class);
            }
            if (channel == Channel.BALANCES) {
                return fromJson(message, BalancesSnapshot.class);
            }
            if (channel == Channel.TRADING) {
                return fromJson(message, TradingSnapshot.class);
            }
        } else {
            return new Event(seqnum, event.name(), channel.name());
        }
        return new Event(seqnum, event.name(), channel.name());
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

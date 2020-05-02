package client;

import config.ClientConfig;
import decoders.EventDecoder;
import encoders.ActionEncoder;
import handlers.EventHandler;
import handlers.HeartbeatHandler;
import handlers.OrderUpdateHandler;
import model.Channel;
import model.OrderType;
import model.Side;
import model.TimeInForce;
import model.actions.*;
import model.events.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class BcxClient implements ExchangeClient {
    public static final String BCX_WS_ENDPOINT = "wss://ws.prod.blockchain.info/mercury-gateway/v1/ws";
    private final Logger logger = LoggerFactory.getLogger(BcxClient.class);
    private final ClientEndpointConfig config;
    private Session session;
    private EventHandler eventHandler;
    private HeartbeatHandler heartbeatHandler;
    private EventHandler l2UpdateHandler;
    private OrderUpdateHandler orderUpdateHandler;

    public BcxClient() {
        final ClientEndpointConfig.Builder configBuilder = ClientEndpointConfig.Builder.create();
        configBuilder.configurator(new ClientConfig());

        final List<Class<? extends Decoder>> decoders = new ArrayList<>();
        decoders.add(EventDecoder.class);
        configBuilder.decoders(decoders);

        final List<Class<? extends Encoder>> encoders = new ArrayList<>();
        encoders.add(ActionEncoder.class);
        configBuilder.encoders(encoders);

        config = configBuilder.build();
    }

    @Override
    public boolean connect(String apiKey) {
        final WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        try {
            session = container.connectToServer(ClientEndpoint.class, config, new URI(BCX_WS_ENDPOINT));
            send(new SubscribeAuth(apiKey));
            session.addMessageHandler(new MessageHandler.Whole<Event>() {
                @Override
                public void onMessage(Event event) {
                    logger.info("new event: " + event.toString());
                    if (event instanceof Heartbeat) {
                        handleHeartbeat((Heartbeat) event);
                    } else if (event instanceof L2Snapshot) {
                        handleL2Snapshot((L2Snapshot) event);
                    } else if (event instanceof L2Update) {
                        handleL2Update((L2Update) event);
                    } else if (event instanceof TradingUpdate) {
                        handleOrderUpdate((TradingUpdate) event);
                    }
                }
            });
            return true;
        } catch (Exception e) {
            logger.error("error while connecting to the exchange", e);
            return false;
        }
    }

    @Override
    public void subscribeAll() {
        send(new Subscribe(Channel.TRADING));
        send(new Subscribe(Channel.HEARTBEAT));
    }

    @Override
    public void subscribeAll(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
        send(new Subscribe(Channel.TRADING));
        send(new Subscribe(Channel.HEARTBEAT));
    }

    @Override
    public void createOrder(String clientOrderId,
                            String symbol,
                            OrderType orderType,
                            TimeInForce timeInForce,
                            Side side,
                            double orderQty,
                            double price,
                            boolean addLiquidityOnly
    ) {
        send(new OrderAction(clientOrderId, symbol, orderType, timeInForce, side, orderQty, price, addLiquidityOnly));
    }

    @Override
    public void cancelOrder(String orderId) {
        send(new CancelAction(orderId));
    }

    private void handleL2Snapshot(L2Snapshot l2Snapshot) {
        logger.info("handling new L2Snapshot: " + l2Snapshot);
    }

    private void handleL2Update(L2Update l2Update) {
        logger.info("handling new L2Update: " + l2Update);
        l2UpdateHandler.handle(l2Update);
    }

    private void handleHeartbeat(Heartbeat heartbeat) {
        if (heartbeatHandler == null && eventHandler == null) {
            logger.warn("no heartbeat or event handler is defined");
        }
        if (heartbeatHandler != null) {
            heartbeatHandler.handle(heartbeat);
        }
        if (eventHandler != null) {
            eventHandler.handle(heartbeat);
        }
    }

    private void handleOrderUpdate(TradingUpdate update) {
        orderUpdateHandler.handle(update);
    }

    public void subscribeTrading() {
        send(new Subscribe(Channel.TRADING));
    }

    @Override
    public void subscribeHeartbeat() {
        send(new Subscribe(Channel.HEARTBEAT));
    }

    @Override
    public void subscribeHeartbeat(HeartbeatHandler handler) {
        this.heartbeatHandler = handler;
        send(new Subscribe(Channel.HEARTBEAT));
    }

    public void subscribeL2OrderBook(String symbol) {
        send(new SubscribeL2(symbol));
    }

    public void send(Object message) {
        final RemoteEndpoint.Basic remote = session.getBasicRemote();
        try {
            remote.sendObject(message);
        } catch (IOException | EncodeException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onHeartbeat(HeartbeatHandler handler) {
        this.heartbeatHandler = handler;
    }

    public void onL2OrderBookUpdate(EventHandler handler) {
        this.l2UpdateHandler = handler;
    }

    public void onOrderUpdate(OrderUpdateHandler handler) {
        this.orderUpdateHandler = handler;
    }
}

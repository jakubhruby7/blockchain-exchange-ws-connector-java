package client;

import config.ClientConfig;
import decoders.EventDecoder;
import encoders.ActionEncoder;
import encoders.OrderEncoder;
import encoders.SubscriptionEncoder;
import handlers.Handler;
import handlers.OrderUpdateHandler;
import model.*;
import model.actions.CancelAction;
import model.actions.OrderAction;
import model.actions.Subscribe;
import model.events.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class BcxClient implements ExchangeClient {
    public static final String BCX_WS_ENDPOINT = "wss://ws.prod.blockchain.info/mercury-gateway/v1/ws";
    private final Logger logger = LoggerFactory.getLogger(BcxClient.class);
    private final ClientEndpointConfig config;
    private Session session;
    private Handler heartbeatHandler;
    private Handler l2UpdateHandler;
    private OrderUpdateHandler orderUpdateHandler;

    public BcxClient() {
        final ClientEndpointConfig.Builder configBuilder = ClientEndpointConfig.Builder.create();
        configBuilder.configurator(new ClientConfig());

        final List<Class<? extends Decoder>> decoders = new ArrayList<>();
        decoders.add(EventDecoder.class);
        configBuilder.decoders(decoders);

        final List<Class<? extends Encoder>> encoders = new ArrayList<>();
        encoders.add(SubscriptionEncoder.class);
        encoders.add(OrderEncoder.class);
        encoders.add(ActionEncoder.class);
        configBuilder.encoders(encoders);

        config = configBuilder.build();
    }

    public boolean connect(String apiKey) {
        final WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        try {
            session = container.connectToServer(ClientEndpoint.class, config, new URI(BCX_WS_ENDPOINT));
            final RemoteEndpoint.Basic remote = session.getBasicRemote();
            remote.sendObject(new Subscribe("subscribe", "auth", apiKey));
            remote.sendText("{\"action\":\"subscribe\", \"channel\":\"auth\", \"token\": \"" + apiKey + "\"}");
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
    public void createOrder(String clientOrderId,
                            String symbol,
                            OrderType orderType,
                            TimeInForce timeInForce,
                            Side side,
                            BigDecimal orderQty,
                            BigDecimal price,
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
        heartbeatHandler.handle(heartbeat);
    }

    private void handleOrderUpdate(TradingUpdate update) {
        orderUpdateHandler.handle(update);
    }

    public void subscribeAll() {
        send(new Subscribe("subscribe", "trading"));
        send(new Subscribe("subscribe", "heartbeat"));
    }

    public void subscribeTrading() {
        send(new Subscribe("subscribe", "trading"));
    }

    public void subscribeHeartbeat() {
        send(new Subscribe("subscribe", "heartbeat"));
    }

    public void subscribeL2OrderBook(String symbol) {
        send(new Subscribe("subscribe", "l2", symbol));
    }

    public void send(Object message) {
        final RemoteEndpoint.Basic remote = session.getBasicRemote();
        try {
            remote.sendObject(message);
        } catch (IOException | EncodeException e) {
            e.printStackTrace();
        }
    }

    public void onHeartbeat(Handler handler) {
        this.heartbeatHandler = handler;
    }

    public void onL2OrderBookUpdate(Handler handler) {
        this.l2UpdateHandler = handler;
    }

    public void onOrderUpdate(OrderUpdateHandler handler) {
        this.orderUpdateHandler = handler;
    }
}

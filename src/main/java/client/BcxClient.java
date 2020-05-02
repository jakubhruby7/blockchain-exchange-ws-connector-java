package client;

import config.ClientConfig;
import decoders.EventDecoder;
import encoders.ActionEncoder;
import handlers.*;
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
    private L2Handler l2Handler;
    private L3Handler l3Handler;
    private PricesHandler pricesHandler;
    private SymbolsHandler symbolsHandler;
    private TickerHandler tickerHandler;
    private TradesHandler tradesHandler;
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
                    } else if (event instanceof L2) {
                        handleL2((L2) event);
                    } else if (event instanceof L3) {
                        handleL3((L3) event);
                    } else if (event instanceof PricesUpdate) {
                        handlePrices((PricesUpdate) event);
                    } else if (event instanceof SymbolsSnapshot) {
                        handleSymbols((SymbolsSnapshot) event);
                    } else if (event instanceof TickerSnapshot) {
                        handleTicker((TickerSnapshot) event);
                    } else if (event instanceof TradesUpdate) {
                        handleTrades((TradesUpdate) event);
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
    public void onEvent(EventHandler handler) {
        this.eventHandler = handler;
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

    @Override
    public void onHeartbeat(HeartbeatHandler handler) {
        this.heartbeatHandler = handler;
    }

    @Override
    public void subscribeL2(String symbol) {
        send(new SubscribeL2(symbol));
    }

    @Override
    public void subscribeL2(String symbol, L2Handler handler) {
        this.l2Handler = handler;
        send(new SubscribeL2(symbol));
    }

    @Override
    public void onL2(L2Handler handler) {
        this.l2Handler = handler;
    }

    @Override
    public void subscribeL3(String symbol) {
        send(new SubscribeL3(symbol));
    }

    @Override
    public void subscribeL3(String symbol, L3Handler handler) {
        this.l3Handler = handler;
        send(new SubscribeL3(symbol));
    }

    @Override
    public void onL3(L3Handler handler) {
        this.l3Handler = handler;
    }

    @Override
    public void subscribePrices(String symbol, int granularity) {
        send(new SubscribePrices(symbol, granularity));
    }

    @Override
    public void subscribePrices(String symbol, int granularity, PricesHandler handler) {
        this.pricesHandler = handler;
        send(new SubscribePrices(symbol, granularity));
    }

    @Override
    public void onPrices(PricesHandler handler) {
        this.pricesHandler = handler;
    }

    @Override
    public void subscribeSymbols() {
        send(new Subscribe(Channel.SYMBOLS));
    }

    @Override
    public void subscribeSymbols(SymbolsHandler handler) {
        this.symbolsHandler = handler;
        send(new Subscribe(Channel.SYMBOLS));
    }

    @Override
    public void subscribeTicker(String symbol) {
        send(new SubscribeTicker(symbol));
    }

    @Override
    public void subscribeTicker(String symbol, TickerHandler handler) {
        this.tickerHandler = handler;
        send(new SubscribeTicker(symbol));
    }

    @Override
    public void subscribeTrades(String symbol) {
        send(new SubscribeTrades(symbol));
    }

    @Override
    public void subscribeTrades(String symbol, TradesHandler handler) {
        this.tradesHandler = handler;
        send(new SubscribeTrades(symbol));
    }

    @Override
    public void onTrades(TradesHandler handler) {
        this.tradesHandler = handler;
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

    private void handleL2(L2 l2) {
        if (l2Handler == null && eventHandler == null) {
            logger.warn("no l2 or event handler is defined");
        }
        if (l2Handler != null) {
            l2Handler.handle(l2);
        }
        if (eventHandler != null) {
            eventHandler.handle(l2);
        }
    }

    private void handleL3(L3 l3) {
        if (l3Handler == null && eventHandler == null) {
            logger.warn("no l3 or event handler is defined");
        }
        if (l3Handler != null) {
            l3Handler.handle(l3);
        }
        if (eventHandler != null) {
            eventHandler.handle(l3);
        }
    }

    private void handlePrices(PricesUpdate pricesUpdate) {
        if (pricesHandler == null && eventHandler == null) {
            logger.warn("no prices or event handler is defined");
        }
        if (pricesHandler != null) {
            pricesHandler.handle(pricesUpdate);
        }
        if (eventHandler != null) {
            eventHandler.handle(pricesUpdate);
        }
    }

    private void handleSymbols(SymbolsSnapshot symbolsSnapshot) {
        if (symbolsHandler == null && eventHandler == null) {
            logger.warn("no symbols or event handler is defined");
        }
        if (symbolsHandler != null) {
            symbolsHandler.handle(symbolsSnapshot);
        }
        if (eventHandler != null) {
            eventHandler.handle(symbolsSnapshot);
        }
    }

    private void handleTicker(TickerSnapshot tickerSnapshot) {
        if (tickerHandler == null && eventHandler == null) {
            logger.warn("no ticker or event handler is defined");
        }
        if (tickerHandler != null) {
            tickerHandler.handle(tickerSnapshot);
        }
        if (eventHandler != null) {
            eventHandler.handle(tickerSnapshot);
        }
    }

    private void handleTrades(TradesUpdate tradesUpdate) {
        if (tradesHandler == null && eventHandler == null) {
            logger.warn("no trades or event handler is defined");
        }
        if (tradesHandler != null) {
            tradesHandler.handle(tradesUpdate);
        }
        if (eventHandler != null) {
            eventHandler.handle(tradesUpdate);
        }
    }

    private void handleOrderUpdate(TradingUpdate update) {
        orderUpdateHandler.handle(update);
    }

    public void subscribeTrading() {
        send(new Subscribe(Channel.TRADING));
    }

    public void send(Object message) {
        final RemoteEndpoint.Basic remote = session.getBasicRemote();
        try {
            remote.sendObject(message);
        } catch (IOException | EncodeException e) {
            e.printStackTrace();
        }
    }

    public void onOrderUpdate(OrderUpdateHandler handler) {
        this.orderUpdateHandler = handler;
    }
}

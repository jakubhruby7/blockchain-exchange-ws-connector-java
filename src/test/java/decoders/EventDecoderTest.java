package decoders;

import model.OrderType;
import model.Side;
import model.TimeInForce;
import model.events.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventDecoderTest {

    final EventDecoder decoder = new EventDecoder();

    @Test
    void decodeSubscribedHeartbeat() {
        Event event = decoder.decode(EventExamples.subscribedHeartbeat());
        assertEquals(Subscribed.class, event.getClass());

        Subscribed subscribed = (Subscribed) event;
        assertEquals("heartbeat", subscribed.getChannel());
        assertEquals("subscribed", subscribed.getEvent());
    }

    @Test
    void decodeUpdatedHeartbeat() {
        Event event = decoder.decode(EventExamples.updatedHeartbeat());
        assertEquals(Heartbeat.class, event.getClass());

        Heartbeat heartbeat = (Heartbeat) event;
        assertEquals("heartbeat", heartbeat.getChannel());
        assertEquals("updated", heartbeat.getEvent());
        assertEquals("2019-05-31T08:36:45.666753Z", heartbeat.getTimestamp());
    }

    @Test
    void decodeSubscribedL2() {
        Event event = decoder.decode(EventExamples.subsribedL2());
        assertEquals(SubscribedL2.class, event.getClass());

        SubscribedL2 subscribed = (SubscribedL2) event;
        assertEquals("l2", subscribed.getChannel());
        assertEquals("subscribed", subscribed.getEvent());
        assertEquals("BTC-USD", subscribed.getSymbol());
    }

    @Test
    void decodeSnapshotL2() {
        Event event = decoder.decode(EventExamples.snapshotL2());
        assertEquals(L2.class, event.getClass());

        L2 l2Snapshot = (L2) event;
        assertEquals("l2", l2Snapshot.getChannel());
        assertEquals("snapshot", l2Snapshot.getEvent());
        assertEquals("BTC-USD", l2Snapshot.getSymbol());

        assertEquals(2, l2Snapshot.getBids().length);
        assertEquals(2, l2Snapshot.getAsks().length);

        assertEquals(2, l2Snapshot.getBids()[0].getNum());
        assertEquals(8723.45, l2Snapshot.getBids()[0].getPrice());
        assertEquals(1.45, l2Snapshot.getBids()[0].getQuantity());

        assertEquals(1, l2Snapshot.getBids()[1].getNum());
        assertEquals(8124.45, l2Snapshot.getBids()[1].getPrice());
        assertEquals(123.45, l2Snapshot.getBids()[1].getQuantity());

        assertEquals(2, l2Snapshot.getAsks()[0].getNum());
        assertEquals(8730.0, l2Snapshot.getAsks()[0].getPrice());
        assertEquals(1.55, l2Snapshot.getAsks()[0].getQuantity());

        assertEquals(2, l2Snapshot.getAsks()[1].getNum());
        assertEquals(8904.45, l2Snapshot.getAsks()[1].getPrice());
        assertEquals(13.66, l2Snapshot.getAsks()[1].getQuantity());
    }

    @Test
    void decodeUpdatedL2() {
        Event event = decoder.decode(EventExamples.updatedL2());
        assertEquals(L2.class, event.getClass());

        L2 l2 = (L2) event;
        assertEquals("l2", l2.getChannel());
        assertEquals("updated", l2.getEvent());
        assertEquals("BTC-USD", l2.getSymbol());
        assertEquals(1, l2.getBids().length);
        assertEquals(0, l2.getAsks().length);

        assertEquals(1, l2.getBids()[0].getNum());
        assertEquals(8723.45, l2.getBids()[0].getPrice());
        assertEquals(1.1, l2.getBids()[0].getQuantity());
    }

    @Test
    void decodeSnapshotL3() {
        Event event = decoder.decode(EventExamples.snapshotL3());
        assertEquals(L3.class, event.getClass());

        L3 l3Snapshot = (L3) event;
        assertEquals("l3", l3Snapshot.getChannel());
        assertEquals("snapshot", l3Snapshot.getEvent());
        assertEquals("BTC-USD", l3Snapshot.getSymbol());
        assertEquals(3, l3Snapshot.getBids().length);
        assertEquals(4, l3Snapshot.getAsks().length);

        assertEquals("1234", l3Snapshot.getBids()[0].getId());
        assertEquals(8723.45, l3Snapshot.getBids()[0].getPrice());
        assertEquals(1.1, l3Snapshot.getBids()[0].getQuantity());

        assertEquals("1235", l3Snapshot.getBids()[1].getId());
        assertEquals(8723.45, l3Snapshot.getBids()[1].getPrice());
        assertEquals(0.35, l3Snapshot.getBids()[1].getQuantity());

        assertEquals("234", l3Snapshot.getBids()[2].getId());
        assertEquals(8124.45, l3Snapshot.getBids()[2].getPrice());
        assertEquals(123.45, l3Snapshot.getBids()[2].getQuantity());

        assertEquals("2222", l3Snapshot.getAsks()[0].getId());
        assertEquals(8730.0, l3Snapshot.getAsks()[0].getPrice());
        assertEquals(0.65, l3Snapshot.getAsks()[0].getQuantity());

        assertEquals("2225", l3Snapshot.getAsks()[1].getId());
        assertEquals(8730.0, l3Snapshot.getAsks()[1].getPrice());
        assertEquals(0.9, l3Snapshot.getAsks()[1].getQuantity());

        assertEquals("2343", l3Snapshot.getAsks()[2].getId());
        assertEquals(8904.45, l3Snapshot.getAsks()[2].getPrice());
        assertEquals(8.66, l3Snapshot.getAsks()[2].getQuantity());

        assertEquals("2353", l3Snapshot.getAsks()[3].getId());
        assertEquals(8904.45, l3Snapshot.getAsks()[3].getPrice());
        assertEquals(5.0, l3Snapshot.getAsks()[3].getQuantity());
    }

    @Test
    void decodeUpdatedL3() {
        Event event = decoder.decode(EventExamples.updatedL3());
        assertEquals(L3.class, event.getClass());

        L3 l3 = (L3) event;
        assertEquals("l3", l3.getChannel());
        assertEquals("updated", l3.getEvent());
        assertEquals("BTC-USD", l3.getSymbol());
        assertEquals(0, l3.getAsks().length);
        assertEquals(1, l3.getBids().length);
        assertEquals("1234", l3.getBids()[0].getId());
        assertEquals(8723.45, l3.getBids()[0].getPrice());
        assertEquals(0, l3.getBids()[0].getQuantity());
    }

    @Test
    void decodeSubscribedPrices() {
        Event event = decoder.decode(EventExamples.subscribedPrices());
        assertEquals(SubscribedPrices.class, event.getClass());

        SubscribedPrices subscribed = (SubscribedPrices) event;
        assertEquals("prices", subscribed.getChannel());
        assertEquals("subscribed", subscribed.getEvent());
        assertEquals("BTC-USD", subscribed.getSymbol());
    }

    @Test
    void decodeUpdatedPrices() {
        Event event = decoder.decode(EventExamples.updatedPrices());
        assertEquals(PricesUpdate.class, event.getClass());

        PricesUpdate pricesUpdate = (PricesUpdate) event;
        assertEquals("prices", pricesUpdate.getChannel());
        assertEquals("updated", pricesUpdate.getEvent());
        assertEquals(1559039640, pricesUpdate.getPrice()[0]);
        assertEquals(8697.24, pricesUpdate.getPrice()[1]);
        assertEquals(8700.98, pricesUpdate.getPrice()[2]);
        assertEquals(8697.27, pricesUpdate.getPrice()[3]);
        assertEquals(8700.98, pricesUpdate.getPrice()[4]);
        assertEquals(0.431, pricesUpdate.getPrice()[5]);
    }

    @Test
    void decodeSnapshotSymbols() {
        Event event = decoder.decode(EventExamples.snapshotSymbols());
        assertEquals(SymbolsSnapshot.class, event.getClass());

        SymbolsSnapshot symbolsSnapshot = (SymbolsSnapshot) event;
        assertEquals("symbols", symbolsSnapshot.getChannel());
        assertEquals("snapshot", symbolsSnapshot.getEvent());
        assertEquals(5, symbolsSnapshot.getSymbols().size());
        assertEquals("BTC", symbolsSnapshot.getSymbols().get("BTC-USD").getBaseCurrency());
        assertEquals(8, symbolsSnapshot.getSymbols().get("BTC-USD").getBaseCurrencyScale());
        assertEquals("USD", symbolsSnapshot.getSymbols().get("BTC-USD").getCounterCurrency());
        assertEquals(2, symbolsSnapshot.getSymbols().get("BTC-USD").getCounterCurrencyScale());
        assertEquals(10, symbolsSnapshot.getSymbols().get("BTC-USD").getMinPriceIncrement());
        assertEquals(0, symbolsSnapshot.getSymbols().get("BTC-USD").getMinPriceIncrementScale());
        assertEquals(50, symbolsSnapshot.getSymbols().get("BTC-USD").getMinOrderSize());
        assertEquals(2, symbolsSnapshot.getSymbols().get("BTC-USD").getMinOrderSizeScale());
        assertEquals(0, symbolsSnapshot.getSymbols().get("BTC-USD").getMaxOrderSize());
        assertEquals(8, symbolsSnapshot.getSymbols().get("BTC-USD").getMaxOrderSizeScale());
        assertEquals(5, symbolsSnapshot.getSymbols().get("BTC-USD").getLotSize());
        assertEquals(2, symbolsSnapshot.getSymbols().get("BTC-USD").getLotSizeScale());
        assertEquals("halt", symbolsSnapshot.getSymbols().get("BTC-USD").getStatus());
        assertEquals(1, symbolsSnapshot.getSymbols().get("BTC-USD").getId());
        assertEquals(0.0, symbolsSnapshot.getSymbols().get("BTC-USD").getAuctionPrice());
        assertEquals(0.0, symbolsSnapshot.getSymbols().get("BTC-USD").getAuctionSize());
        assertEquals("", symbolsSnapshot.getSymbols().get("BTC-USD").getAuctionTime());
        assertEquals(0.0, symbolsSnapshot.getSymbols().get("BTC-USD").getImbalance());
    }

    @Test
    void decodeSnapshotTicker() {
        Event event = decoder.decode(EventExamples.snapshotTicker());
        assertEquals(TickerSnapshot.class, event.getClass());

        TickerSnapshot tickerSnapshot = (TickerSnapshot) event;
        assertEquals("ticker", tickerSnapshot.getChannel());
        assertEquals("snapshot", tickerSnapshot.getEvent());
        assertEquals("BTC-USD", tickerSnapshot.getSymbol());
        assertEquals(4988.0, tickerSnapshot.getPrices24h());
        assertEquals(0.3015, tickerSnapshot.getVolume24h());
        assertEquals(5000.0, tickerSnapshot.getLastTradePrice());
    }

    @Test
    void decodeUpdatedTrades() {
        Event event = decoder.decode(EventExamples.updatedTrades());
        assertEquals(TradesUpdate.class, event.getClass());

        TradesUpdate tradesUpdate = (TradesUpdate) event;
        assertEquals("trades", tradesUpdate.getChannel());
        assertEquals("updated", tradesUpdate.getEvent());
        assertEquals("BTC-USD", tradesUpdate.getSymbol());
        assertEquals("2019-08-13T11:30:06.100140Z", tradesUpdate.getTimestamp());
        assertEquals(Side.SELL, tradesUpdate.getSide());
        assertEquals(8.5E-5, tradesUpdate.getQuantity());
        assertEquals(11252.4, tradesUpdate.getPrice());
        assertEquals("12884909920", tradesUpdate.getTradeId());
    }

    @Test
    void decodeSnapshotTrading() {
        Event event = decoder.decode(EventExamples.snapshotTrading());
        assertEquals(TradingSnapshot.class, event.getClass());

        TradingSnapshot tradingSnapshot = (TradingSnapshot) event;
        assertEquals("trading", tradingSnapshot.getChannel());
        assertEquals("snapshot", tradingSnapshot.getEvent());
        assertEquals("12891851020", tradingSnapshot.getOrders()[0].getOrderId());
        assertEquals("78502a08-c8f1-4eff-b", tradingSnapshot.getOrders()[0].getClientOrderId());
        assertEquals("BTC-USD", tradingSnapshot.getOrders()[0].getSymbol());
        assertEquals(Side.SELL, tradingSnapshot.getOrders()[0].getSide());
        assertEquals(OrderType.LIMIT, tradingSnapshot.getOrders()[0].getOrderType());
        assertEquals(5.0e-4, tradingSnapshot.getOrders()[0].getOrderQty());
        assertEquals(5.0e-4, tradingSnapshot.getOrders()[0].getLeavesQty());
        assertEquals(0.0, tradingSnapshot.getOrders()[0].getCumQty());
        assertEquals(0.0, tradingSnapshot.getOrders()[0].getAvgPx());
        assertEquals("open", tradingSnapshot.getOrders()[0].getOrdStatus());
        assertEquals(TimeInForce.GTC, tradingSnapshot.getOrders()[0].getTimeInForce());
        assertEquals("New order", tradingSnapshot.getOrders()[0].getText());
        assertEquals("0", tradingSnapshot.getOrders()[0].getExecType());
        assertEquals("11321871", tradingSnapshot.getOrders()[0].getExecId());
        assertEquals("2019-08-13T11:30:03.000593290Z", tradingSnapshot.getOrders()[0].getTransactTime());
        assertEquals(8, tradingSnapshot.getOrders()[0].getMsgType());
        assertEquals(0.0, tradingSnapshot.getOrders()[0].getLastPx());
        assertEquals(0.0, tradingSnapshot.getOrders()[0].getLastShares());
        assertEquals("0", tradingSnapshot.getOrders()[0].getTradeId());
        assertEquals(15000.0, tradingSnapshot.getOrders()[0].getPrice());
    }

    @Test
    void decodeUpdateTrading() {
        Event event = decoder.decode(EventExamples.updateTrading());
        assertEquals(TradingUpdate.class, event.getClass());

        TradingUpdate tradingUpdate = (TradingUpdate) event;
        assertEquals("trading", tradingUpdate.getChannel());
        assertEquals("updated", tradingUpdate.getEvent());
        assertEquals("999999878", tradingUpdate.getOrderId());
        assertEquals("Client ID 3", tradingUpdate.getClientOrderId());
    }
}
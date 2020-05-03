package com.blockchain.bcx;

import com.blockchain.bcx.client.BcxClient;
import com.blockchain.bcx.model.OrderType;
import com.blockchain.bcx.model.Side;
import com.blockchain.bcx.model.TimeInForce;

public class Example {

    final static String key = "";

    public static void main(String[] args) {
        final BcxClient bcxClient = new BcxClient();
        bcxClient.connect(key);

        // subscribe to all basic channels trading, balances, heartbeat, symbols
        bcxClient.subscribeAll();

        // subscribe to L3 data and handle updates
        bcxClient.subscribeL3("BTC-USD", l3 -> System.out.println("l3 update - " + l3.toString()));

        // subscribe to candlestick data and handle updates
        bcxClient.subscribePrices("BTC-USD", 60, pricesUpdate -> System.out.println("candlestick 60s - " + pricesUpdate.toString()));

        // subscribe to trades and handle updates
        bcxClient.subscribeTrades("BTC-USD", tradesUpdate -> System.out.println("trade - " + tradesUpdate.toString()));

        // handle balance snapshot updates
        bcxClient.onBalances(balancesSnapshot -> System.out.println("balanceSnapshot - " + balancesSnapshot.toString()));

        // handle trading updates
        bcxClient.onTrading(tradingEvent -> System.out.println("tradingEvent - " + tradingEvent.toString()));

        // cancel the order that will be sent below
        bcxClient.onTradingUpdate(tradingUpdate -> {
            bcxClient.cancelOrder(tradingUpdate.getOrderId());
        });
        // create an order (you'll have to have enough balance ($5) to be able to place this order
        // price - $5000, size - 0.001 BTC
        bcxClient.createOrder(
                "bcx-api-1",
                "BTC-GBP",
                OrderType.LIMIT,
                TimeInForce.GTC,
                Side.BUY,
                "0.001",
                "5000",
                true
        );
    }
}

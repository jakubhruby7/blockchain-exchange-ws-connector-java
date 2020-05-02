# blockchain-exchange-ws-connector-java
Websocket connector for Blockchain Exchange (exchange.blockchain.com) written in Java.

# Connect to the Blockchain Exchange
### create a client instance
``final BcxClient bcxClient = new BcxClient();``
### connect to the Exchange 
key - API key that can be generated through exchange.blockchain.com/api

`bcxClient.connect(key);`

# Channels
This section describes available websocket channels.
### All
You can connect to all channel by using the following command 
  
`bcxClient.subscribeAll();`

If you would like to receive all the updates from all channels you can do it in the following ways

either by passing a handler when subscribing to all channels  

`bcxClient.subscribeAll(event -> System.out.println("event - " + event.toString()));`

or by passing a handler in the following method

```
bcxClient.subscribeAll();
bcxClient.onEvent(event -> System.out.println("event - " + event.toString()));
```

### Heartbeat
Heartbeat channel is used for receiving heartbeat events from the exchange. Heartbeat messages are sent every 5 seconds.  

You can connect to the heartbeat channel using the following command  

`bcxClient.subscribeHeartbeat();`

To receive heartbeat events you can either pass a handler when subscribing to the heartbeat channel  

`bcxClient.subscribeHeartbeat(heartbeat -> System.out.println("heartbeat - " + heartbeat.toString()));`

or use a separate method

`bcxClient.onHeartbeat(heartbeat -> System.out.println("heartbeat - " + heartbeat.toString()));`

### L2 Order Book
L2 channel is used for receiving L2 order book events from the exchange.   

You can connect to the l2 channel using the following command  

`bcxClient.subscribeL2("BTC-USD");`

To receive l2 events you can either pass a handler when subscribing to the l2 channel  

`bcxClient.subscribeL2("BTC-USD", l2 -> System.out.println("l2 - " + l2.toString()));`

or use a separate method

`bcxClient.onL2(l2 -> System.out.println("l2 - " + l2.toString()));`

### L3 Order Book
L3 channel is used for receiving L3 order book events from the exchange.   

You can connect to the l3 channel using the following command  

`bcxClient.subscribeL3("BTC-USD");`

To receive l3 events you can either pass a handler when subscribing to the l3 channel  

`bcxClient.subscribeL3("BTC-USD", l3 -> System.out.println("l3 - " + l3.toString()));`

or use a separate method

`bcxClient.onL3(l3 -> System.out.println("l3 - " + l3.toString()));`

### Prices
Prices channel is used for receiving candlestick market data events from the exchange.   

You can connect to the prices channel using the following command  

`bcxClient.subscribePrices("BTC-USD", 60);`

To receive prices events you can either pass a handler when subscribing to the prices channel  

`bcxClient.subscribePrices("BTC-USD", 60, pricesUpdate -> System.out.println("prices - " + pricesUpdate.toString()));`

or use a separate method

`bcxClient.onPrices(pricesUpdate -> System.out.println("prices - " + pricesUpdate.toString()));`

### Symbols
Symbols channel is used for receiving symbol updates from the exchange.   

You can connect to the symbols channel using the following command  

`bcxClient.subscribeSymbols();`

To receive symbols updates you can pass a handler when subscribing to the symbols channel  

`bcxClient.subscribeSymbols(symbolsSnapshot -> System.out.println("symbol snapshot - " + symbolsSnapshot.getSymbols()));`

### Ticker
Ticker channel is used for receiving ticker updates from the exchange.   

You can connect to the ticker channel using the following command  

`bcxClient.subscribeTicker("BTC-USD");`

To receive symbols updates you can pass a handler when subscribing to the ticker channel  

`bcxClient.subscribeTicker("BTC-USD", tickerSnapshot -> System.out.println("ticker - " + tickerSnapshot.toString()));`

### Trades
Trades channel is used for receiving trade update events from the exchange.   

You can connect to the trades channel using the following command  

`bcxClient.subscribeTrades("BTC-USD");`

To receive trades events you can either pass a handler when subscribing to the trades channel  

`bcxClient.onTrades(tradesUpdate -> System.out.println("tradesUpdate - " + tradesUpdate.toString()));`

or use a separate method

`bcxClient.onTrades(tradesUpdate -> System.out.println("tradesUpdate - " + tradesUpdate.toString()));`

### Trading
Trading channel is used for sending new orders, cancelling existing orders and receiving trading updates from the exchange.   

#### Subscription
You can subscribe to the trading channel using the following command  

`bcxClient.subscribeTrading();`

To receive all trades events you can either pass a handler when subscribing to the trading channel  

`bcxClient.subscribeTrading(tradingEvent -> System.out.println("tradingEvent - " + tradingEvent.toString()));`

or use a separate method

`bcxClient.onTrading(tradingEvent -> System.out.println("tradingEvent - " + tradingEvent.toString()));`

You can also receive only specific trading events by passing separate handler either when subscribing to the trading channel

```
bcxClient.subscribeTrading(tradingSnapshot -> {
        System.out.println("trading snapshot - " + tradingSnapshot.toString());
    }, tradingUpdate ->  {
        System.out.println("trading snapshot - " + tradingUpdate.toString());
    }, tradingRejected -> {
        System.out.println("trading snapshot - " + tradingRejected.toString());
    });
```

or use separate methods
```$java
bcxClient.onTradingSnapshot(tradingSnapshot -> System.out.println("tradingSnapshot - " + tradingSnapshot.toString()));
bcxClient.onTradingUpdate(tradingUpdate -> System.out.println("tradingUpdate - " + tradingUpdate.toString()));
bcxClient.onTradingReject(tradingRejected -> System.out.println("tradingRejected - " + tradingRejected.toString()));
```

#### Creating a new order
You can create a new order in the following way  

```$java
bcxClient.createOrder(
            "bcx-api-1",
            "BTC-GBP",
            OrderType.LIMIT,
            TimeInForce.GTC,
            Side.BUY,
            0.001,
            5000,
            true
    );
```

#### Cancel an existing order
You can cancel an existing order in the following way

`bcxClient.cancelOrder("123");`

### Balances
Balances channel is used for receiving balance snapshot events from the exchange.   

You can connect to the balances channel using the following command  

`bcxClient.subscribeBalances();`

To receive balance events you can either pass a handler when subscribing to the balances channel  

`bcxClient.subscribeBalances(balancesSnapshot -> System.out.println("balanceSnapshot - " + balancesSnapshot.toString()));`

or use a separate method

`bcxClient.onBalances(balancesSnapshot -> System.out.println("balanceSnapshot - " + balancesSnapshot.toString()));`

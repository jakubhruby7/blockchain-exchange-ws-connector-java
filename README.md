## Blockchain.com Exchange Websocket Client
Websocket connector for Blockchain.com Exchange (https://exchange.blockchain.com) written in Java.

## How to get started
First create a client instance  
``final BcxClient bcxClient = new BcxClient();``  
  
Connect to the exchange with your API key (you can generate one on https://exchange.blockchain.com/settings/api)
`bcxClient.connect(key);` 

## Channels
This section describes all the available websocket channels.   
Full description of each channel - https://exchange.blockchain.com/api/#websocket-api
### All
You can connect to all channel by using the following command 
  
   ```bcxClient.subscribeAll();```

If you'd like to receive all the updates from all the channels you can do it in the following ways  

1. By passing a handler when subscribing to all channels
    ```
    bcxClient.subscribeAll(event -> System.out.println("event - " + event.toString()));
    ```
2. By passing a handler to the `onEvent` method
    ```
    bcxClient.subscribeAll();
    bcxClient.onEvent(event -> System.out.println("event - " + event.toString()));
    ```

This will receive all the events of type `Event`. If you'd like to receive more specific events you can use channel specific handlers described below.

### Heartbeat
Heartbeat channel is used for receiving `Heartbeat` events from the exchange that help with identifying if the exchange is reachable. Heartbeat messages are sent every 5 seconds.  

You can connect to the heartbeat channel using the following command  

`bcxClient.subscribeHeartbeat();`

To receive `Heartbeat` events you can 

1. Pass a handler when subscribing to the heartbeat channel  
    ```
    bcxClient.subscribeHeartbeat(heartbeat -> System.out.println("heartbeat - " + heartbeat.toString()));
    ```
2. Use a separate `onHeartbeat` method after subscription
    ```
    bcxClient.subscribeHeartbeat()
    bcxClient.onHeartbeat(heartbeat -> System.out.println("heartbeat - " + heartbeat.toString()));
    ```

### L2 Order Book
L2 channel is used for receiving `L2` order book events from the exchange.   

You can connect to the L2 channel using the following command  

`bcxClient.subscribeL2("BTC-USD");`

It requires passing a `symbol` parameter that represents a trading pair available on the exchange  

To receive `L2` events you can 
1. Pass a handler when subscribing to the L2 channel  
    ```
    bcxClient.subscribeL2("BTC-USD", l2 -> System.out.println("l2 - " + l2.toString()));
    ```
2. Use a separate `onL2` method after subscription
    ```
    bcxClient.subscribeL2("BTC-USD");
    bcxClient.onL2(l2 -> System.out.println("l2 - " + l2.toString()));
    ```

### L3 Order Book
L3 channel is used for receiving `L3` order book events from the exchange.   

You can connect to the L3 channel using the following command  

`bcxClient.subscribeL3("BTC-USD");`

To receive `L3` events you can 
1. Pass a handler when subscribing to the L3 channel  
    ```
    bcxClient.subscribeL3("BTC-USD", l3 -> System.out.println("l3 - " + l3.toString()));
    ```
2. Use a separate `onL3` method after subscription
    ```
    bcxClient.subscribeL3("BTC-USD");
    bcxClient.onL3(l3 -> System.out.println("l3 - " + l3.toString()));
    ```

### Prices
Prices channel is used for receiving candlestick market data events (`PricesUpdate`) from the exchange.   

You can connect to the prices channel using the following command  

`bcxClient.subscribePrices("BTC-USD", 60);`

To receive `PricesUpdate` events you can 
1. Pass a handler when subscribing to the prices channel  
    ```
    bcxClient.subscribePrices("BTC-USD", 60, pricesUpdate -> System.out.println("prices - " + pricesUpdate.toString()));
    ```
2. Use a separate `onPrices` method after subscription
    ```
    bcxClient.subscribePrices("BTC-USD", 60);
    bcxClient.onPrices(pricesUpdate -> System.out.println("prices - " + pricesUpdate.toString()));
    ```

### Symbols
Symbols channel is used for receiving symbol updates (`SymbolsSnapshot`) from the exchange.   

You can connect to the symbols channel using the following command  

`bcxClient.subscribeSymbols();`

To receive `SymbolsSnapshot` you can pass a handler when subscribing to the symbols channel  
```
bcxClient.subscribeSymbols(symbolsSnapshot -> System.out.println("symbol snapshot - " + symbolsSnapshot.getSymbols()));
```

### Ticker
Ticker channel is used for receiving ticker updates (`TickerSnapshot`) from the exchange.   

You can connect to the ticker channel using the following command  

`bcxClient.subscribeTicker("BTC-USD");`

To receive `TickerSnapshot` updates you can pass a handler when subscribing to the ticker channel  
```
bcxClient.subscribeTicker("BTC-USD", tickerSnapshot -> System.out.println("ticker - " + tickerSnapshot.toString()));
```

### Trades
Trades channel is used for receiving trade update events (`TradesUpdate`) from the exchange.   

You can connect to the trades channel using the following command  

`bcxClient.subscribeTrades("BTC-USD");`

To receive `TradesUpdate` events you can 
1. Pass a handler when subscribing to the trades channel  
    ```
    bcxClient.onTrades(tradesUpdate -> System.out.println("tradesUpdate - " + tradesUpdate.toString()));
    ```
2. Use a separate `onTrades` method after subscription
    ```
    bcxClient.subscribeTrades("BTC-USD");
    bcxClient.onTrades(tradesUpdate -> System.out.println("tradesUpdate - " + tradesUpdate.toString()));
    ```

### Trading
Trading channel is used for sending new orders, cancelling existing orders and receiving trading updates from the exchange.   

#### Subscription
You can subscribe to the trading channel using the following command  

`bcxClient.subscribeTrading();`

To receive all trading events you can 
1. Pass a handler when subscribing to the trading channel  
    ```
    bcxClient.subscribeTrading(tradingEvent -> System.out.println("tradingEvent - " + tradingEvent.toString()));
    ```
2. Use a separate `onTrading` method after subscription
    ```
    bcxClient.subscribeTrading();
    bcxClient.onTrading(tradingEvent -> System.out.println("tradingEvent - " + tradingEvent.toString()));
    ```

To receive only specific trading events you can 
1. Pass separate handlers when subscribing to the trading channel
    ```
    bcxClient.subscribeTrading(tradingSnapshot -> {
            System.out.println("trading snapshot - " + tradingSnapshot.toString());
        }, tradingUpdate ->  {
            System.out.println("trading snapshot - " + tradingUpdate.toString());
        }, tradingRejected -> {
            System.out.println("trading snapshot - " + tradingRejected.toString());
        });
    ```
2. Use separate methods after subscription
    ```
    bcxClient.subscribeTrading();
    bcxClient.onTradingSnapshot(tradingSnapshot -> System.out.println("tradingSnapshot - " + tradingSnapshot.toString()));
    bcxClient.onTradingUpdate(tradingUpdate -> System.out.println("tradingUpdate - " + tradingUpdate.toString()));
    bcxClient.onTradingReject(tradingRejected -> System.out.println("tradingRejected - " + tradingRejected.toString()));
    ```

#### Creating a new order
You can create a new order and send it to the exchange in the following way  

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

#### Cancelling an existing order
You can cancel an existing order in the following way

`bcxClient.cancelOrder("123");`

Passed parameter is an order id that is received after placing a new order.

### Balances
Balances channel is used for receiving balance snapshot events (`BalanceSnapshot`) from the exchange.   

You can connect to the balances channel using the following command  

`bcxClient.subscribeBalances();`

To receive `BalanceSnapshot` events you can 
1. Pass a handler when subscribing to the balances channel  
    ```
    bcxClient.subscribeBalances(balancesSnapshot -> System.out.println("balanceSnapshot - " + balancesSnapshot.toString()));
    ```
2. Use a separate `onBalances` method
    ```
    bcxClient.subscribeBalances();
    bcxClient.onBalances(balancesSnapshot -> System.out.println("balanceSnapshot - " + balancesSnapshot.toString()));
    ```

## TODO
* Optimise the library for speed (speed up Json parsing)
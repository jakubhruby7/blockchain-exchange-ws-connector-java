import client.BcxClient;
import model.OrderType;
import model.Side;
import model.TimeInForce;

import java.math.BigDecimal;

public class Example {

    final static String key = "your_key";

    public static void main(String[] args) {
        final BcxClient bcxClient = new BcxClient();
        bcxClient.connect(key);
        bcxClient.subscribeAll();
//        bcxClient.subscribeL2OrderBook("BTC-USD");
//        bcxClient.onL2OrderBookUpdate(event -> { System.out.println("l2 update handler - " + event.toString()); });
//            bcxClient.send("{\"action\":\"subscribe\", \"channel\":\"trading\"}");
//        bcxClient.onHeartbeat(event -> { System.out.println("heartbeat handler - " + event.toString()); });
        bcxClient.createOrder(
                "bcx-api-1",
                "BTC-GBP",
                OrderType.LIMIT,
                TimeInForce.GTC,
                Side.BUY,
                new BigDecimal("0.001"),
                new BigDecimal("5000"),
                true
        );

        bcxClient.onOrderUpdate(event -> {
            System.out.println("new order update order id: " + event.getOrderId());
            System.out.println("cancelling an order");
            bcxClient.cancelOrder(event.getOrderId());
        });

    }
}

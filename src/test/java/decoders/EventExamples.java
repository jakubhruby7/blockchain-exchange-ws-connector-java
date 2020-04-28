package decoders;

public class EventExamples {

    static String subscribedHeartbeat() {
        return "{\n" +
                "  \"seqnum\": 0,\n" +
                "  \"event\": \"subscribed\",\n" +
                "  \"channel\": \"heartbeat\"\n" +
                "}";
    }

    static String subsribedL2() {
        return "{\n" +
                "  \"seqnum\": 1,\n" +
                "  \"event\": \"subscribed\",\n" +
                "  \"channel\": \"l2\",\n" +
                "  \"symbol\": \"BTC-USD\"\n" +
                "}";
    }

    static String updatedHeartbeat() {
        return "{\n" +
                "  \"seqnum\": 1,\n" +
                "  \"event\": \"updated\",\n" +
                "  \"channel\": \"heartbeat\",\n" +
                "  \"timestamp\": \"2019-05-31T08:36:45.666753Z\"\n" +
                "}";
    }

    static String snapshotL2() {
        return "{\n" +
                "  \"seqnum\": 2,\n" +
                "  \"event\": \"snapshot\",\n" +
                "  \"channel\": \"l2\",\n" +
                "  \"symbol\": \"BTC-USD\",\n" +
                "  \"bids\": [\n" +
                "    {\n" +
                "      \"px\": 8723.45,\n" +
                "      \"qty\": 1.45,\n" +
                "      \"num\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"px\": 8124.45,\n" +
                "      \"qty\": 123.45,\n" +
                "      \"num\": 1\n" +
                "    }\n" +
                "  ],\n" +
                "  \"asks\": [\n" +
                "    {\n" +
                "      \"px\": 8730.0,\n" +
                "      \"qty\": 1.55,\n" +
                "      \"num\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"px\": 8904.45,\n" +
                "      \"qty\": 13.66,\n" +
                "      \"num\": 2\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }

    static String updatedL2() {
        return "{\n" +
                "  \"seqnum\": 3,\n" +
                "  \"event\": \"updated\",\n" +
                "  \"channel\": \"l2\",\n" +
                "  \"symbol\": \"BTC-USD\",\n" +
                "  \"bids\": [\n" +
                "    {\n" +
                "      \"px\": 8723.45,\n" +
                "      \"qty\": 1.1,\n" +
                "      \"num\": 1\n" +
                "    }\n" +
                "  ],\n" +
                "  \"asks\": []\n" +
                "}";
    }

    static String snapshotL3() {
        return "{\n" +
                "  \"seqnum\": 2,\n" +
                "  \"event\": \"snapshot\",\n" +
                "  \"channel\": \"l3\",\n" +
                "  \"symbol\": \"BTC-USD\",\n" +
                "  \"bids\": [\n" +
                "    {\n" +
                "      \"id\": \"1234\",\n" +
                "      \"px\": 8723.45,\n" +
                "      \"qty\": 1.1\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"1235\",\n" +
                "      \"px\": 8723.45,\n" +
                "      \"qty\": 0.35\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"234\",\n" +
                "      \"px\": 8124.45,\n" +
                "      \"qty\": 123.45\n" +
                "    }\n" +
                "  ],\n" +
                "  \"asks\": [\n" +
                "    {\n" +
                "      \"id\": \"2222\",\n" +
                "      \"px\": 8730.0,\n" +
                "      \"qty\": 0.65\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"2225\",\n" +
                "      \"px\": 8730.0,\n" +
                "      \"qty\": 0.9\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"2343\",\n" +
                "      \"px\": 8904.45,\n" +
                "      \"qty\": 8.66\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"2353\",\n" +
                "      \"px\": 8904.45,\n" +
                "      \"qty\": 5.0\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }

    static String updatedL3() {
        return "{\n" +
                "  \"seqnum\": 3,\n" +
                "  \"event\": \"updated\",\n" +
                "  \"channel\": \"l3\",\n" +
                "  \"symbol\": \"BTC-USD\",\n" +
                "  \"bids\": [\n" +
                "    {\n" +
                "      \"id\": \"1234\",\n" +
                "      \"px\": 8723.45,\n" +
                "      \"qty\": 0\n" +
                "    }\n" +
                "  ],\n" +
                "  \"asks\": []\n" +
                "}";
    }

    static String subscribedPrices() {
        return "{\n" +
                "  \"seqnum\": 0,\n" +
                "  \"event\": \"subscribed\",\n" +
                "  \"channel\": \"prices\",\n" +
                "  \"symbol\": \"BTC-USD\"\n" +
                "}";
    }

    static String updatedPrices() {
        return "{\n" +
                "  \"seqnum\": 2,\n" +
                "  \"event\": \"updated\",\n" +
                "  \"channel\": \"prices\",\n" +
                "  \"symbol\": \"BTC-USD\",\n" +
                "  \"price\": [1559039640, 8697.24, 8700.98, 8697.27, 8700.98, 0.431]\n" +
                "}";
    }

    static String snapshotTrading() {
        return "{\n" +
                "  \"seqnum\": 3,\n" +
                "  \"event\": \"snapshot\",\n" +
                "  \"channel\": \"trading\",\n" +
                "  \"orders\": [\n" +
                "    {\n" +
                "      \"orderID\": \"12891851020\",\n" +
                "      \"clOrdID\": \"78502a08-c8f1-4eff-b\",\n" +
                "      \"symbol\": \"BTC-USD\",\n" +
                "      \"side\": \"sell\",\n" +
                "      \"ordType\": \"limit\",\n" +
                "      \"orderQty\": 5.0e-4,\n" +
                "      \"leavesQty\": 5.0e-4,\n" +
                "      \"cumQty\": 0.0,\n" +
                "      \"avgPx\": 0.0,\n" +
                "      \"ordStatus\": \"open\",\n" +
                "      \"timeInForce\": \"GTC\",\n" +
                "      \"text\": \"New order\",\n" +
                "      \"execType\": \"0\",\n" +
                "      \"execID\": \"11321871\",\n" +
                "      \"transactTime\": \"2019-08-13T11:30:03.000593290Z\",\n" +
                "      \"msgType\": 8,\n" +
                "      \"lastPx\": 0.0,\n" +
                "      \"lastShares\": 0.0,\n" +
                "      \"tradeId\": \"0\",\n" +
                "      \"price\": 15000.0\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }

    static String updateTrading() {
        return "{\n" +
                "  \"seqnum\": 3,\n" +
                "  \"event\": \"updated\",\n" +
                "  \"channel\": \"trading\",\n" +
                "  \"msgType\": \"8\",\n" +
                "  \"clOrdID\": \"Client ID 3\",\n" +
                "  \"orderID\": \"999999878\",\n" +
                "  \"ordStatus\": \"open\",\n" +
                "  \"execType\": \"0\",\n" +
                "  \"symbol\": \"BTC-USD\",\n" +
                "  \"side\": \"sell\",\n" +
                "  \"orderQty\": 10.0,\n" +
                "  \"ordType\": \"limit\",\n" +
                "  \"price\": 3400.0,\n" +
                "  \"transactTime\": \"2019-08-13T13:09:34.000659345Z\",\n" +
                "  \"leavesQty\": 10.0,\n" +
                "  \"cumQty\": 0.0,\n" +
                "  \"avgPx\": 0.0\n" +
                "}";
    }
}

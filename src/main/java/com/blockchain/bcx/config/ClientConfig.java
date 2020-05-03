package com.blockchain.bcx.config;

import javax.websocket.ClientEndpointConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClientConfig extends ClientEndpointConfig.Configurator {

    public static final String BLOCKCHAIN_ORIGIN = "https://exchange.blockchain.com";
    public static final String ORIGIN_HEADER = "Origin";

    @Override
    public void beforeRequest(Map<String, List<String>> headers) {
        final List<String> values = new ArrayList<>();
        values.add(BLOCKCHAIN_ORIGIN);
        headers.put(ORIGIN_HEADER, values);
    }
}

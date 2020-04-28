package client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;

public class ClientEndpoint extends Endpoint {

    final Logger logger = LoggerFactory.getLogger(ClientEndpoint.class);

    @Override
    public void onOpen(Session session, EndpointConfig config) {
        logger.info("websocket connection open [sessionId=" + session.getId() + "]");
    }

    @Override
    public void onClose(Session session, CloseReason closeReason) {
        logger.info("websocket connection closed [sessionId=" + session.getId() + "]");
    }
}

package encoders;

import model.actions.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.JsonUtils;

import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class SubscriptionEncoder implements Encoder.Text<Subscribe> {

    final Logger logger = LoggerFactory.getLogger(SubscriptionEncoder.class);

    @Override
    public String encode(Subscribe object) {
        return JsonUtils.toJson(object);
    }

    @Override
    public void init(EndpointConfig config) {
        logger.info("SubscriptionEncoder - init method called");
    }

    @Override
    public void destroy() {
        logger.info("SubscriptionEncoder - destroy method called");
    }
}

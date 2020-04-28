package encoders;

import model.actions.OrderAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.JsonUtils;

import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class OrderEncoder implements Encoder.Text<OrderAction> {

    final Logger logger = LoggerFactory.getLogger(OrderEncoder.class);

    @Override
    public String encode(OrderAction object) {
        String json = JsonUtils.toJson(object);
        logger.info("order action: " + json);
        return JsonUtils.toJson(object);
    }

    @Override
    public void init(EndpointConfig config) {
        logger.info("OrderEncoder - init method called");
    }

    @Override
    public void destroy() {
        logger.info("OrderEncoder - destroy method called");
    }
}

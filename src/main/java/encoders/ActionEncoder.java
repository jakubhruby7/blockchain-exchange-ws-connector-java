package encoders;

import model.actions.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.JsonUtils;

import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class ActionEncoder implements Encoder.Text<Action> {

    final Logger logger = LoggerFactory.getLogger(ActionEncoder.class);

    @Override
    public String encode(Action object) {
        String json = JsonUtils.toJson(object);
        logger.info("action: " + json);
        return JsonUtils.toJson(object);
    }

    @Override
    public void init(EndpointConfig config) {
        logger.info("ActionEncoder - init method called");
    }

    @Override
    public void destroy() {
        logger.info("ActionEncoder - destroy method called");
    }
}

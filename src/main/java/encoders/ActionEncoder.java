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
        final String json = JsonUtils.toJson(object);
        logger.info("action: " + json);
        return json;
    }

    @Override
    public void init(EndpointConfig config) {
        logger.debug("ActionEncoder - init method called");
    }

    @Override
    public void destroy() {
        logger.debug("ActionEncoder - destroy method called");
    }
}

package model.actions;

import model.Channel;

public class Subscribe extends Action {

    public Subscribe(Channel channel) {
        this.action = ActionType.SUBSCRIBE;
        this.channel = channel;
    }
}

package model.actions;

import model.Channel;

public class SubscribeAuth extends Subscribe {
    private String token;

    public SubscribeAuth(String token) {
        super(Channel.AUTH);
        this.token = token;
    }
}

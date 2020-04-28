package model.actions;

public class Subscribe extends Action {
    private String symbol;
    private int granularity;

    public Subscribe(String action, String channel) {
        this.action = action;
        this.channel = channel;
    }

    public Subscribe(String action, String channel, String symbol) {
        this.action = action;
        this.channel = channel;
        this.symbol = symbol;
    }

    public Subscribe(String action, String channel, String symbol, int granularity) {
        this.action = action;
        this.channel = channel;
        this.symbol = symbol;
        this.granularity = granularity;
    }
}

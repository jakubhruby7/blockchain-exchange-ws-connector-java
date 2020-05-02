package model.events;

import com.google.gson.annotations.SerializedName;
import model.Balance;

import java.util.Arrays;

public class BalancesSnapshot extends Event {
    private Balance[] balances;
    @SerializedName("total_available_local")
    private double totalAvailableLocal;
    @SerializedName("total_balance_local")
    private double totalBalanceLocal;

    public BalancesSnapshot(String seqnum, String event, String channel) {
        super(seqnum, event, channel);
    }

    public Balance[] getBalances() {
        return balances;
    }

    public double getTotalAvailableLocal() {
        return totalAvailableLocal;
    }

    public double getTotalBalanceLocal() {
        return totalBalanceLocal;
    }

    @Override
    public String toString() {
        return "BalancesSnapshot{" +
                "balances=" + Arrays.toString(balances) +
                ", totalAvailableLocal=" + totalAvailableLocal +
                ", totalBalanceLocal=" + totalBalanceLocal +
                '}';
    }
}
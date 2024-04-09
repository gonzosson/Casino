package net.viklander;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Player {
    String name;
    private BigDecimal balance;

    public Player(String name, BigDecimal balance) {
        this.name = name;
        this.balance = balance.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

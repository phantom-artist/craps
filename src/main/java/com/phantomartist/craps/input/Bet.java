package com.phantomartist.craps.input;

import com.phantomartist.craps.game.Point;

public class Bet {

    private Point point;
    private int wager;

    public Bet(final Point point, final int bet) {
        this.point = point;
        this.wager = bet;
    }

    public int getWager() {
        return wager;
    }

    public Point getPoint() {
        return point;
    }
}

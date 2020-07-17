package com.phantomartist.craps.input;

import static com.phantomartist.craps.game.Output.say;

import java.util.Scanner;

import com.phantomartist.craps.game.Game;
import com.phantomartist.craps.game.Point;

public class PlayerBet {

    private Scanner scanner;

    public PlayerBet() {
        scanner = new Scanner(System.in);
    }

    public Bet getWager() {
        final Point point = whichNumber();
        if (point != null) {
            final int wager = howMuch(point);
            if (wager > 0) {
                return new Bet(point, wager);
            }
        }
        return null;
    }

    private Point whichNumber() {
        Point point = null;
        while (point == null) {
            say("Place bet on number " + Point.getPointsAsString() + 
                " (or 0 to continue): ");
            final int number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            point = Point.getPoint(number);
            if (point == null) {
                say("Invalid number (" + number + 
                    "), please pick a point number (" + 
                    Point.getPointsAsString() + ")");
            }
        }
        return point;
    }

    private int howMuch(final Point point) {
        int wager = 0;
        while (wager == 0) {
            say("How much? (0 to skip): ");
            final int number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            if (point.isPreferredMultiple(number)) {
                wager = number;
            } else if (number < Game.TABLE_MINIMUM) {
                say("Table minimum is $" + Game.TABLE_MINIMUM);
            } else {
                say("Bets for " + point.getPoint() + 
                    " should be a multiple of " + 
                    point.getPreferredMultiple());
            }
        }
        return wager;
    }
}
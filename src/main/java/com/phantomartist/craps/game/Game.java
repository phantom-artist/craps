package com.phantomartist.craps.game;

import static com.phantomartist.craps.game.Output.say;

import com.phantomartist.craps.input.Bet;
import com.phantomartist.craps.input.PlayerBet;
import com.phantomartist.craps.roll.Dice;

public class Game {

    // Table minimum bet - this is used as the basic Passline bet
    public static final int TABLE_MINIMUM = 5;

    private Dice dice;

    private Point point;

    private Player player; // Could make multiplayer?

    public Game() {
    }
    
    /**
     * Start a new game.
     * 
     * Note: Bets are always considered "off" for come-out roll.
     */
    public void newGame() {

        // Reset player & bankroll - 
        player = new Player();

        // New dice each time
        dice = new Dice();

        say("Starting bankroll is $" + player.getBankroll());

        // New shooter (coming out)
        player.newShooter();
        say("Passline bet is table minimum, bankroll is $" + 
            player.getBankroll());

        while (!gameOver()) {
            if (point == null) {
                setPoint();
            }
            hitPointOrSeven();
        }
        
        // End of roll, tally
        say("Ending bankroll is $" + player.getBankroll());
    }

    private boolean gameOver() {
        // If point is set, and dice == 7, game over!
        return point != null && dice.getCurrentTotal() == 7;
    }

    private void setPoint() {

        while (point == null) {

            doBetting();
            say("Coming out...");
            dice.roll();

            final Point p = Point.getPoint(dice.getCurrentTotal());
            if (p != null) {
                point = p;
                say("Point is " + point.getBanter());
            } else {
                final Crap c = Crap.getCrap(dice.getCurrentTotal());
                if (c != null) {
                    say("Loser! " + c.getBanter());
                    player.lose(TABLE_MINIMUM);
                    say("Bankroll is $" + player.getBankroll());
                } else {
                    say("Winner!");
                    player.pay(TABLE_MINIMUM);
                    say("Bankroll is $" + player.getBankroll());
                }
            }

//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    private void doBetting() {

        final PlayerBet playerBet = new PlayerBet();
        while (true) {
            final Bet bet = playerBet.getWager();
            if (bet == null) {
                break;
            }
            if (player.getBankroll() < bet.getWager()) {
                say("Can't do bet, bankroll too low");
            } else {
                player.addBet(bet);
            }
        }
        say(player.currentBetsAsString());
        say("Bankroll is $" + player.getBankroll());
    }

    private void hitPointOrSeven() {

        while (true) {

            doBetting();

            dice.roll();

            if (dice.getCurrentTotal() == 7) {
                say("Seven out!");
                break;
            } else if (point.getPoint() == dice.getCurrentTotal()) {
                // Winner!
                say("Point winner!");
                player.pay(TABLE_MINIMUM);
                say("Bankroll is $" + player.getBankroll());
                point = null; // Puck is Off
                break;
            } else {
                // Is it a number we have money on?
                final Point point = Point.getPoint(dice.getCurrentTotal());
                if (point != null) {
                    final int currentWager = player.getCurrentWagerOn(point);
                    if (currentWager > 0) {
                        final double winnings = point.pay(currentWager);
                        player.pay(winnings);
                        say("Winner on " + point.getBanter() + "! $" + winnings);
                        say("Bankroll is $" + player.getBankroll());
                    }
                }
            }
            
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}

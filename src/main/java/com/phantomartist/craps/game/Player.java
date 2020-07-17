package com.phantomartist.craps.game;

import java.util.HashMap;
import java.util.Map;

import com.phantomartist.craps.input.Bet;

public class Player {

    // Naive implementation - assumes basic bets on numbers with no odds
    private Map<Point,Integer> bets;
    private double bankroll;

    public Player() {
        bets = new HashMap<>();
        bankroll = 100;
    }
    
    /**
     * New shooter must lay a minimum passline bet
     */
    public void newShooter() {
        bankroll -= Game.TABLE_MINIMUM;
    }
    
    public void addBet(final Bet bet) {
        
        final Point point = bet.getPoint();
        Integer existingWager = bets.get(point);
        if (existingWager == null) {
            existingWager = Integer.valueOf(0);
        } 
        bets.put(point, Integer.valueOf(existingWager.intValue() + bet.getWager()));

        bankroll -= bet.getWager();
    }

    public int getCurrentWagerOn(final Point point) {
        final Integer currentWager = bets.get(point);
        if (currentWager == null) {
            return 0;
        }
        return currentWager.intValue();
    }
    
    public void lose(final double amount) {
        bankroll -= amount;
    }
    
    public void pay(final double winnings) {
        bankroll += winnings;
    }
    
    public double getBankroll() {
        return bankroll;
    }
    
    public String currentBetsAsString() {
        final StringBuilder output = 
            new StringBuilder("Current bets : [$")
            .append(Game.TABLE_MINIMUM).append(" on Passline]");

        for (Map.Entry<Point, Integer> entry : bets.entrySet()) {
            output
            .append(" [$")            
            .append(entry.getValue().intValue())
            .append(" on ")
            .append(entry.getKey().getPoint())
            .append("]");
        }
        return output.toString();
    }
}

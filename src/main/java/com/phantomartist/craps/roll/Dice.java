package com.phantomartist.craps.roll;

import com.phantomartist.craps.game.Crap;
import com.phantomartist.craps.game.Point;

public class Dice {
    
    private Die die1;
    private Die die2;
    
    public Dice() {
        // New dice!
        die1 = new Die();
        die2 = new Die();
    }
    
    public void roll() {
        die1.roll();
        die2.roll();
        printDice();
    }
    
    public void printDice() {
        System.out.println("\n\n" +
            ASCIIDie.getRender(die1.getRoll()) + 
            ASCIIDie.getRender(die2.getRoll())
            );
    }
    
    public int getCurrentTotal() {
        return die1.getRoll() + die2.getRoll();
    }
    
    public boolean isAPoint() {
        return Point.getPoint(getCurrentTotal()) != null;
    }
    
    public boolean isCraps() {
        return Crap.getCrap(getCurrentTotal()) != null;
    }
}

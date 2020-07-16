package com.phantomartist.craps.roll;

import java.security.SecureRandom;

public class Die {

    private SecureRandom generator;
    private int roll;
    
    public Die() {
        generator = new SecureRandom();
    }

    public void roll() {
        
        int roll = 0;
        while (roll == 0) {
            roll = generator.nextInt(7);
        }
        this.roll = roll;
    }
    
    public int getRoll() {
        return roll;
    }
}

package com.phantomartist.craps.roll;

public enum Point {
    
    FOUR(4, 9.0/5.0, "Four to score"),
    FIVE(5, 7.0/5.0, "No field five"),
    SIX(6, 7.0/6.0, "Six, easy"),
    EIGHT(8, 7.0/6.0, "Eight, easy"),
    NINE(9, 7.0/5.0, "Nein, nein said the frauline"),
    TEN(10, 9.0/5.0, "Ten, ten again");
    
    private int point;
    private String banter;
    private double odds;
    
    private Point(final int point, final double odds, final String banter) {
        this.point = point;
        this.odds = odds;
        this.banter = banter;
    }
    
    public int getPoint() {
        return point;
    }
    
    public String getBanter() {
        return banter;
    }
    
    public double pay(final int bet) {
        return odds * bet;
    }
    
    public static Point getPoint(int number) {
        for (Point p : values()) {
            if (p.getPoint() == number) {
                return p;
            }
        }
        return null;
    }
}

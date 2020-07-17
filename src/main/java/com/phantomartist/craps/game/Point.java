package com.phantomartist.craps.game;

public enum Point {
    
    FOUR(4, 9.0/5.0, 5, "Four to score"),
    FIVE(5, 7.0/5.0, 5, "No field five"),
    SIX(6, 7.0/6.0, 6, "Six, easy"),
    EIGHT(8, 7.0/6.0, 6, "Eight, easy"),
    NINE(9, 7.0/5.0, 5, "Nein, nein said the frauline"),
    TEN(10, 9.0/5.0, 5, "Ten, ten again");
    
    private int point;
    private double odds;
    private int preferredMultiple;
    private String banter;
    
    private Point(final int point, final double odds, final int preferredMultiple, final String banter) {
        this.point = point;
        this.odds = odds;
        this.preferredMultiple = preferredMultiple;
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
    
    public int getPreferredMultiple() {
        return preferredMultiple;
    }

    public boolean isPreferredMultiple(int bet) {
        return preferredMultiple % bet == 0;
    }
    
    public static Point getPoint(int number) {
        for (Point p : values()) {
            if (p.getPoint() == number) {
                return p;
            }
        }
        return null;
    }
    
    public static String getPointsAsString() {
        return "4, 5, 6, 8, 9, 10";
    }
}

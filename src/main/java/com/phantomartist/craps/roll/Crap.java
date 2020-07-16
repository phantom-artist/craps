package com.phantomartist.craps.roll;

public enum Crap {

	TWO(2, "Two bad guys from Van Nyes"),
	THREE(3, "Three crap dice"),
	TWELVE(12, "Boxcars... that's all the dots-we-gots!");
	
	private int crap;
	private String banter;
	private Crap(final int crap, final String banter) {
		this.crap = crap;
		this.banter = banter;
	}
	
	public int getCrap() {
		return crap;
	}
	
	public String getBanter() {
		return banter;
	}
	
	public static Crap getCrap(int number) {
		for (Crap c : values()) {
			if (c.getCrap() == number) {
				return c;
			}
		}
		return null;
	}
}

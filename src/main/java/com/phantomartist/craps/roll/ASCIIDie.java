package com.phantomartist.craps.roll;

public class ASCIIDie {

	public static final String ONE =
		"+-------+\n" +
	    "|       |\n" +
		"|   *   |\n" +
	    "|       |\n" +
		"+-------+\n";
	
	public static final String TWO =
		"+-------+\n" +
	    "| *     |\n" +
		"|       |\n" +
	    "|     * |\n" +
		"+-------+\n";
	
	public static final String THREE =
		"+-------+\n" +
	    "| *     |\n" +
		"|   *   |\n" +
	    "|     * |\n" +
		"+-------+\n";
	
	public static final String FOUR =
		"+-------+\n" +
	    "| *   * |\n" +
		"|       |\n" +
	    "| *   * |\n" +
		"+-------+\n";
	
	public static final String FIVE =
		"+-------+\n" +
	    "| *   * |\n" +
		"|   *   |\n" +
	    "| *   * |\n" +
		"+-------+\n";
	
	public static final String SIX =
		"+-------+\n" +
	    "| *   * |\n" +
		"| *   * |\n" +
	    "| *   * |\n" +
		"+-------+\n";
	
	public static String getRender(int number) {
		switch (number) {
		case 1 : return ONE;
		case 2 : return TWO;
		case 3 : return THREE;
		case 4 : return FOUR;
		case 5 : return FIVE;
		case 6 : return SIX;
		default : throw new IllegalArgumentException(number + " is not supported");
		}
	}
}

package com.phantomartist.craps;

import com.phantomartist.craps.roll.Crap;
import com.phantomartist.craps.roll.Dice;
import com.phantomartist.craps.roll.Point;

public class Game {

	private Dice dice;
    
    private Point point;

    private int bankroll;
    
	public Game() {
	}
	
	/**
	 * Assume for each game we have 
	 * $5 pass line
	 * $6 (6, 8)
	 * $5 (4, 5, 9, 10)
	 * 
	 * $37 at risk on each game
	 */
	public void newGame() {
		
		// Reset bankroll - 
		bankroll = 100 - 37;
		
		// New dice each time
		dice = new Dice();
		
		print("Bankroll is $" + bankroll);
		while (!gameOver()) {
			if (point == null) {
				setPoint();
			}
			hitPointOrSeven();
		}
		print("Bankroll is $" + bankroll);
	}
	
	private boolean gameOver() {
		// If point is set, and dice == 7, game over!
		return point != null && dice.getCurrentTotal() == 7;
	}
	
	private void setPoint() {

		while (point == null) {
			
			dice.roll();
			
			final Point p = Point.getPoint(dice.getCurrentTotal());
			if (p != null) {
				point = p;
				print("Point is " + point.getBanter());
			} else {
				final Crap c = Crap.getCrap(dice.getCurrentTotal());
				if (c != null) {
					print("Loser! " + c.getBanter());
					bankroll -= 5;
					print("Bankroll is $" + bankroll);
				} else {
					print("Winner!");
					bankroll += 5;
					print("Bankroll is $" + bankroll);
				}
			}
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void hitPointOrSeven() {
		while (true) {
			dice.roll();
			if (dice.getCurrentTotal() == 7) {
				print("Seven out!");
				break;
			} else if (point.getPoint() == dice.getCurrentTotal()) {
				// Winner!
				print("Point winner!");
				bankroll += 5;
				print("Bankroll is $" + bankroll);
				point = null; // Puck is Off
				break;
			} else {
				// Is it a number we have money on?
				if (dice.getCurrentTotal() == 4 ||
					dice.getCurrentTotal() == 5 ||
					dice.getCurrentTotal() == 9 ||
					dice.getCurrentTotal() == 10) {
					
					bankroll += Point.getPoint(dice.getCurrentTotal()).pay(5);
					print("Bankroll is $" + bankroll);
					
				} else if (dice.getCurrentTotal() == 6 ||
						   dice.getCurrentTotal() == 8) {
					
					bankroll += Point.getPoint(dice.getCurrentTotal()).pay(6);
					print("Bankroll is $" + bankroll);
				}
			}
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void print(final String output) {
		System.out.println(output);
	}
}

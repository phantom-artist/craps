package com.phantomartist.craps;

import com.phantomartist.craps.game.Game;

/**
 * Wrapper
 */
public class App 
{
    public static void main( String[] args )
    {
        final Game g = new Game();
        g.newGame();
    }
}

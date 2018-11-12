/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lkaranko
 */
public class Tile {
    
    private char symbol;
    private String name;
    private boolean passable;
    

    public Tile(char symbol) {
        this.symbol = symbol;
        this.passable = true;
    }

    /**
     * Returns the ascii-character that represents this tile
     * 
     * @return 
     */
    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Returns whether the tile can be moved into
     * 
     * @return 
     */
    public boolean getPassable() {
        return passable;
    }

    /**
     * Set whether a tile can be moved into
     * 
     * @param passable 
     */
    public void setPassable(boolean passable) {
        this.passable = passable;
    }
    
    

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lkaranko
 */
public class Character {

    private char symbol;
    private Coordinates position;

    public Character() {
        this.symbol = '@';
    }

    public Character(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public Coordinates getPosition() {
        return position;
    }
    /**
     * Teleports the character to the position
     * 
     * @param posX
     * @param posY 
     */
    public void setPosition(int posX, int posY) {
        position.setCoordX(posX);
        position.setCoordY(posY);
    }

    /**
     * Moves the character to a new position based on a move vector
     * 
     * @param posX
     * @param posY 
     */
    public void movePosition(int posX, int posY) {
        position.setCoordX(position.getCoordX() + posX);
        position.setCoordY(position.getCoordY() + posY);
    }

}

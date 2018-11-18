/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * The character class contains all information pertaining to characters on the
 * level map
 * 
 * @author lkaranko
 */
public class Character {

    private char symbol;
    public Coordinates position;

    public Character() {
        this.symbol = '@';
        this.position = new Coordinates(0, 0);
    }

    public Character(int posX, int posY) {
        this.symbol = '@';
        this.position = new Coordinates(posX, posY);
    }

    public Character(char symbol, int posX, int posY) {
        this.symbol = symbol;
        this.position = new Coordinates(posX, posY);
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
        position.setCoordXY(posX, posY);
    }

    /**
     * Moves the character to a new position based on a move vector
     *
     * @param posX
     * @param posY
     */
    public void movePosition(int posX, int posY) {
        position.setCoordXY(position.getCoordX() + posX, position.getCoordY() + posY);
    }

}

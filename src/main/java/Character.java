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
    
    char symbol;
    String position;
    int posX, posY;

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
    
    public String getPosition() {
       return position; 
    }

    public void setPosition(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
    
    public void movePosition(int posX, int posY) {
        this.posX += posX;
        this.posY += posY;
    }
    
}

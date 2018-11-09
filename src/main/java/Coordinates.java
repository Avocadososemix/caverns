/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lkaranko
 */
public class Coordinates {

    private int coordX;
    private int coordY;
    
    /**
     * This class is used to store and retrieve the X and Y coordinates of
     * items.
     * 
     * @param coordX
     * @param coordY 
     */
    public Coordinates(int coordX, int coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }
    
    public void setCoordXY(int coordX, int coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }
}

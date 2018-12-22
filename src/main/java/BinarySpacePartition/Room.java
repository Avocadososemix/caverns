/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySpacePartition;

import GameLogic.Coordinates;

/**
 * This is a class-type for Room-objects on the map.
 * 
 * @author lkaranko
 */
public class Room {
    
    private final Coordinates topCorner;
    private final Coordinates botCorner;

    public Room(Coordinates topCorner, Coordinates botCorner) {
        this.topCorner = topCorner;
        this.botCorner = botCorner;
    }
    
    public Room(int x0, int x1, int y0, int y1) {
        this.topCorner = new Coordinates(x0, y0);
        this.botCorner = new Coordinates(x1, y1);
    }

    public Coordinates getTopLeftCorner() {
        return topCorner;
    }

    public Coordinates getBotRightCorner() {
        return botCorner;
    }
    
    public int x0() {
        return topCorner.getCoordX();
    }
    
    public int getWidth() {
        return botCorner.getCoordX();
    }

    public int y0() {
        return topCorner.getCoordY();
    }
    
    public int getHeigth() {
        return botCorner.getCoordY();
    }
    
    public Room dig() {
        return new Room(x0()+1, getWidth()-1, y0()+1, getHeigth()-1);
    }
    
    public Coordinates center() {
        return new Coordinates(x0()+(getWidth()-x0())/2, y0()+(getHeigth()-y0())/2);
    }
    
    public void printCenter() {
        System.out.println("Center- X:" + center().getCoordX() + ",Y:" + center().getCoordY());
    }
    
    public void orderTest() {
        if (getWidth()<x0() || getHeigth()<y0()) {
            System.out.println("This is wrong!!!!!!!!!");
        }
    }

    public void printInfo() {
        System.out.println(x0() +", " +  getWidth() + ", " + y0() + ", " + getHeigth());
    }
    
    public String toString() {
        return x0() +", " +  getWidth() + ", " + y0() + ", " + getHeigth() + ".";
    }
    
    
    
    
}

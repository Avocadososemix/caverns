package BinarySpacePartition;

import GameLogic.Tile;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lkaranko
 */
public class BinarySpacePartition {

    public Tile[][] level;
    private int sizeX, sizeY;
    private Room[] rooms;
    private Rooms roomlist;

    public BinarySpacePartition(Tile[][] level) {
        this.level = level;
        sizeX = level.length;
        sizeY = level[0].length;
        roomlist = new Rooms();
    }

    public char[][] generateRooms() {
        Random r = new Random();
        if (sizeX >= sizeY && sizeX >=10) {
            int cutX = r.nextInt(sizeX); // a value between 0 and sizeX-1
            System.out.println("Cutting point is " + cutX);
            //Tile[][] partition1 = parent;
            Room left = new Room(0, cutX-1, 0, sizeY);
            Room right = new Room(cutX+1, sizeX, 0, sizeY);
            roomlist.addRoom(left);
            roomlist.addRoom(right);
        } else if (sizeX < sizeY) {
            
        }
        return roomMap();
    }
    
    public char[][] roomMap(){
        char[][] temp = new char[5][5];
    return temp;
}
    
    public void Recursion() {
        
    }

}

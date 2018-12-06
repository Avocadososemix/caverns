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

    public BinarySpacePartition(Tile[][] level) {
        this.level = level;
        sizeX = level.length;
        sizeY = level[0].length;
    }

    public void generateInitialRooms(Tile[][] parent) {
        Random r = new Random();
        if (sizeX >= sizeY && sizeX >=10) {
            int cutX = r.nextInt(sizeX); // a value between 0 and sizeX-1
            System.out.println("Cutting point is " + cutX);
            //Tile[][] partition1 = parent;
            Room left = new Room(0, cutX-1, 0, sizeY);
            Room right = new Room(cutX+1, sizeX, 0, sizeY);
            

        } else if (sizeX < sizeY) {
            
        }

    }

}

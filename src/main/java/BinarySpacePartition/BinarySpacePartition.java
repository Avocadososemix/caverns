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
    private Tile[][] level;
    private int sizeX, sizeY;

    public BinarySpacePartition(Tile[][] level) {
        this.level = level;
        sizeX = level.length;
        sizeY = level[0].length;
    }
    
    public void bisectTable() {
        int test = 0;
        while (test != 5) {
        Random r = new Random();
        int cutX = r.nextInt(sizeX);
//        double cutX = Math.floor(sizeX*r.nextDouble());
        System.out.println("value is " + cutX);
        }
        
        
        
    }
    
    
    
}

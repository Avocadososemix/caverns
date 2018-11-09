/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lkaranko
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("Welcome to level 1");
        Level starter = new Level(30, 6);
        starter.initializeLevel();
        System.out.println("");
        
        starter.setWall(2, 2);
        starter.setWall(2, 3);
        
        
//        //Check individual tile
//        char foundChar = starter.getLevelTile(2, 2);
//        System.out.println(foundChar);
//        
        //Print Level
        starter.printLevel();
       // starter.printLevel();
    }
    
}

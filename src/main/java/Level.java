
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lkaranko
 */
public class Level {
    
    public int sizeX, sizeY;
    public Tile[][] tiles;
    public HashMap<Integer[][], Character> characters = new HashMap<Integer[][], Character>();
    
    public Level(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.tiles = new Tile[sizeY][sizeX];
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }
    
    public void initializeLevel() {
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                tiles[i][j] = new Tile('.');
            }
        }
    }
    
    public void setWall(int coordX, int coordY) {
        tiles[coordX][coordY].setSymbol('#');
        tiles[coordX][coordY].setPassable(false);
    }
    
    public void moveCharacter(String direction) {
        
    }
    
    public char getLevelTile(int coordX, int coordY) {
        return tiles[coordX][coordY].getSymbol();
    }
    
    public void printLevel() {
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                System.out.print(tiles[i][j].symbol);
            }
            System.out.println("");
        }
    }
    
    public void printLevelBetter() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
            sb.append(tiles[i][j].symbol);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    
}

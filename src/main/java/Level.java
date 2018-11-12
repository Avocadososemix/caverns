
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * This class will hold the level building logic.
 *
 * @author lkaranko
 */
public class Level {

    public int sizeX, sizeY;
    public Tile[][] tiles;
    public ArrayList<Character> mapObjects = new ArrayList();
    public ArrayList<String> errorLog = new ArrayList<>(); //Can be printed to receive errors with timestamps

    public Level(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.tiles = new Tile[sizeX][sizeY];
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    /**
     * A temporary method to fill the map with empty tiles
     */
    public void initializeLevel() {
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                tiles[j][i] = new Tile('.');
            }
        }
    }

    /**
     * Changes a map tile into a wall tile that is impassable
     *
     * @param coordX
     * @param coordY
     */
    public void setWall(int coordX, int coordY) {
        tiles[coordX][coordY].setSymbol('#');
        tiles[coordX][coordY].setPassable(false);
    }

    /**
     * Moves a character object on the map
     *
     * @param character
     * @param moveX
     * @param moveY
     */
    public void moveCharacter(Character character, int moveX, int moveY) {

        if (character.getPosition().getCoordX() + moveX < sizeX
                && character.getPosition().getCoordY() + moveY < sizeY
                && character.getPosition().getCoordX() + moveX >= 0
                && character.getPosition().getCoordY() + moveY >= 0) {
            character.movePosition(moveX, moveY);
        } else {
            System.out.println("Can't move there");
            errorLog.add("Could not move there" + Time.valueOf(LocalTime.MIN));
        }
    }
    
    public void moveDirection(String direction, Character character) {
        if (direction.trim().equalsIgnoreCase("n")) {
            moveCharacter(character, 0, -1);
        } else if (direction.trim().equalsIgnoreCase("e")) {
            moveCharacter(character, 1, 0);
        } else if (direction.trim().equalsIgnoreCase("s")) {
            moveCharacter(character, 0, 1);
        } else if (direction.trim().equalsIgnoreCase("w")) {
            moveCharacter(character, -1, 0);
        } else {
            errorLog.add("Did not receive valid move command" + Time.valueOf(LocalTime.MIN));
            System.out.println("That's not a valid move.");
        }
    }
    
    public boolean tilePassable(Tile tile) {
        return tile.getPassable();
    }

    /**
     * Adds a character object to the current map
     *
     * @param player
     */
    public void addCharacter(Character player) {
        mapObjects.add(player);
    }

    public char getLevelTile(int coordX, int coordY) {
        return tiles[coordX][coordY].getSymbol();
    }

    /**
     * Prints out the current level
     */
    public void printLevel() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                sb.append(tiles[i][j].getSymbol());
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    //TODO Fix this messy code
    /**
     * Prints out the current level with all map objects
     */
    public void printLevelWithCharacters() {
        char[][] tilesWithCharacters = new char[sizeX][sizeY];
        //fetching symbols that represent background tileset
        for (int j = 0; j < sizeY; j++) {
            for (int i = 0; i < sizeX; i++) {
                tilesWithCharacters[i][j] = (tiles[i][j].getSymbol());
                //System.out.println("Array length: " + tilesWithCharacters.length);
                //System.out.println("X is " + i + " and Y is " + j + ". Max size:" + sizeX + ", "+ sizeY);
            }
        }
        //adding characters to map
        mapObjects.forEach((character) -> {
            System.out.println("Player: " + character.getSymbol() + "\n");
            tilesWithCharacters[character.getPosition().getCoordX()][character.getPosition().getCoordY()] = character.getSymbol();
        });
        //creating a printable version of the map with both tiles and characters
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                sb.append(tilesWithCharacters[j][i]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    
    public ArrayList<String> returnErrorLog() {
        return errorLog;
    }

}

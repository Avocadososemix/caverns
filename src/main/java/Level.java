
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
    
    public void fillWithWalls() {
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                tiles[j][i] = new Tile('#');
                tiles[j][i].setPassable(false);
            }
        }
    }
    
    /**
     * The randomwalk algorithm generates a cavern on the map. The algorithm 
     * starts from the middle of the level, and every loop cycle selects a
     * random direction to "walk to". Whenever the algorithm walks in a 
     * direction, it sets the terrain type of that tile into a passable tile. 
     * When the algorithm reaches an edge of the level, it has run to completion.
     * The algorithm uses the proportions of the map to choose create caverns
     * that have an equal chance to expand to all sides of the level regardless
     * of the distance from the center of the level to any side.
     */
    public void randomWalk() {
        int middleX = sizeX/2;
        int middleY = sizeY/2;
        System.out.printf("Size X: %d Size Y: %d\n", sizeX, sizeY );
        double proportionalSizeX = (sizeX/(sizeX+sizeY*1.0));
        System.out.println(proportionalSizeX);
        setEmpty(middleX, middleY);
        while(true) {
        //while (middleX != sizeX-1 && middleX != 0 && middleY != sizeY-1 && middleY != 0) {
            double random = Math.random();
            if (random < proportionalSizeX/2) {
                middleX++;
                if (middleX>sizeX-1) break;
                setEmpty(middleX, middleY);
            } else if (random < proportionalSizeX) {
                middleX--;
                if (middleX<0) break;
                setEmpty(middleX, middleY);
            } else if (random < (1-(1-proportionalSizeX)/2)) {
                middleY++;
                if (middleY>sizeY-1) break;
                setEmpty(middleX, middleY);
            } else {
                middleY--;
                if (middleX<0) break;
                setEmpty(middleX, middleY);
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
    
    public void setEmpty(int coordX, int coordY) {
        //System.out.println("Setting square " + coordX + ", " + coordY + " empty. Max is " + sizeX + ", " +sizeY);
        tiles[coordX][coordY].setSymbol('.');
        tiles[coordX][coordY].setPassable(true);
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
                && character.getPosition().getCoordY() + moveY >= 0
                && directionPassable(character, moveX, moveY)) {
            character.movePosition(moveX, moveY);
        } else {
            System.out.println("You are blocked from moving there ");
            errorLog.add("Could not move there" + Time.valueOf(LocalTime.MIN));
        }
    }

    public boolean directionPassable(Character character, int moveX, int moveY) {
        int moveLocationX = character.getPosition().getCoordX() + moveX;
        int moveLocationY = character.getPosition().getCoordY() + moveY;
        return tiles[moveLocationX][moveLocationY].getPassable();
    }

    public void moveCommand(String direction, Character character) {
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
            //System.out.println("Player: " + character.getSymbol() + "\n");
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

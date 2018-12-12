package GameLogic;

import BinarySpacePartition.Room;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * This class contains the level building logic.
 *
 * @author lkaranko
 */
public class Level {

    public int sizeX, sizeY;
    public Tile[][] tiles;
    public Character playerCharacter = new Character();
    public ArrayList<String> errorLog = new ArrayList<>(); //Can be printed to receive errors with timestamps, probably easier to remove than implement quickly without ArrayList

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
     * This method fills the map with walls, so that a cavern can be generated
     * by removing wall tiles from the map.
     */
    public void fillWithWalls() {
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                tiles[j][i] = new Tile('#');
                tiles[j][i].setPassable(false);
            }
        }
    }
    
    public void fillSectionWithRooms(Room room) {
        for (int i = 0; i < room.getHeigth(); i++) {
            for (int j = 0; j < room.getWidth(); j++) {
                setEmpty(j,i);
            }
        }
    }
    
    public void connectRooms(ArrayList<Room[]> roomPairs) {
        for (Room[] roomPair : roomPairs) {
            if (roomPair[0].center().getCoordY() == roomPair[1].center().getCoordY()) {
                digTunnelX(roomPair[0].center(), roomPair[1].center());
            } else if (roomPair[0].center().getCoordX() == roomPair[1].center().getCoordX()){
                digTunnelY(roomPair[0].center(), roomPair[1].center());
            } else {
                return;
            }
        }
    }
    
    public void digTunnelX(Coordinates coord1, Coordinates coord2) {
        int yAxis = coord1.getCoordY();
        int first, second;
        if (coord1.getCoordX()<coord2.getCoordX()) {
            first = coord1.getCoordX();
            second = coord2.getCoordX();
        } else {
            second = coord1.getCoordX();
            first = coord2.getCoordX();
        }
        for (int i = first; i < second; i++) {
            setEmpty(i, yAxis);
        }
    }
    
        public void digTunnelY(Coordinates coord1, Coordinates coord2) {
        int xAxis = coord1.getCoordX();
        int first, second;
        if (coord1.getCoordY()<coord2.getCoordY()) {
            first = coord1.getCoordY();
            second = coord2.getCoordY();
        } else {
            second = coord1.getCoordY();
            first = coord2.getCoordY();
        }
        for (int i = first; i < second; i++) {
            setEmpty(xAxis, i);
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
     * of the distance from the centre of the level to any side.
     */
    public void randomWalk() {
        int middleX = sizeX/2;
        int middleY = sizeY/2;
        //System.out.printf("Size X: %d Size Y: %d\n", sizeX, sizeY );
        double proportionalSizeX = (sizeX/(sizeX+sizeY*1.0));
        setEmpty(middleX, middleY);
        while(true) {
            double random = Math.random();
            if (random < proportionalSizeX/2) {
                middleX++;
                if (middleX>sizeX-1) break;
            } else if (random < proportionalSizeX) {
                middleX--;
                if (middleX<0) break;
            } else if (random < (1-(1-proportionalSizeX)/2)) {
                middleY++;
                if (middleY>sizeY-1) break;
            } else {
                middleY--;
                if (middleY<0) break;
            }
            setEmpty(middleX, middleY);
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
     * Changes a map tile into an empty tile that is passable.
     * 
     * @param coordX
     * @param coordY 
     */
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
     * @return 
     */
    public String moveCharacter(Character character, int moveX, int moveY) {

        if (character.getPosition().getCoordX() + moveX < sizeX
                && character.getPosition().getCoordY() + moveY < sizeY
                && character.getPosition().getCoordX() + moveX >= 0
                && character.getPosition().getCoordY() + moveY >= 0
                && directionPassable(character, moveX, moveY)) {
            character.movePosition(moveX, moveY);
            return "";
        } else {
            errorLog.add("Could not move there" + Time.valueOf(LocalTime.MIN));
            return "You are blocked from moving there";
        }
    }

    /**
     * Checks whether the direction is passable for the character.
     * 
     * @param character
     * @param moveX
     * @param moveY
     * @return 
     */
    public boolean directionPassable(Character character, int moveX, int moveY) {
        int moveLocationX = character.getPosition().getCoordX() + moveX;
        int moveLocationY = character.getPosition().getCoordY() + moveY;
        return tiles[moveLocationX][moveLocationY].getPassable();
    }

    //TODO Make directions enum
    /**
     * Parses the move commands given to it, and calls a movement method using
     * the cardinal direction given to it.
     * 
     * @param direction
     * @param character 
     * @return  
     */
    public String moveCommand(String direction, Character character) {
        if (direction.trim().equalsIgnoreCase("n")) {
            return moveCharacter(character, 0, -1);
        } else if (direction.trim().equalsIgnoreCase("e")) {
            return moveCharacter(character, 1, 0);
        } else if (direction.trim().equalsIgnoreCase("s")) {
            return moveCharacter(character, 0, 1);
        } else if (direction.trim().equalsIgnoreCase("w")) {
            return moveCharacter(character, -1, 0);
        } else {
            errorLog.add("Did not receive valid move command" + Time.valueOf(LocalTime.MIN));
            return "That's not a valid move.";
        }
    }

    /**
     * Adds a character object to the current map
     *
     * @param player
     */
    public void addCharacter(Character player) {
        //mapObjects.add(player);
        playerCharacter = player;
    }

    /**
     * Returns the tile symbol at the requested location.
     * 
     * @param coordX
     * @param coordY
     * @return 
     */
    public Tile getLevelTile(int coordX, int coordY) {
        return tiles[coordX][coordY];
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

    /**
     * Prints out the whole current level with all map objects
     */
    public void printLevelWithCharacters() {
        char[][] tilesWithCharacters = new char[sizeX][sizeY];
        //fetching symbols that represent background tileset
        for (int j = 0; j < sizeY; j++) {
            for (int i = 0; i < sizeX; i++) {
                tilesWithCharacters[i][j] = (tiles[i][j].getSymbol());
            }
        }
        //adding characters to map
            tilesWithCharacters[playerCharacter.getPosition().getCoordX()][playerCharacter.getPosition().getCoordY()] = playerCharacter.getSymbol();
        
//        mapObjects.forEach((character) -> {
//            tilesWithCharacters[character.getPosition().getCoordX()][character.getPosition().getCoordY()] = character.getSymbol();
//        });
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
    
    /**
     * Gives the map printing method the tile symbols of location on the map.
     * Returns a preset symbol for positions outside the generated map.
     * 
     * @param x
     * @param y
     * @return 
     */
    public char tileRelativeToCharacterSymbol(int x, int y) {
        if (x < 0 || x >= sizeX || y < 0 || y >= sizeY) {
        return '▒';
    } else {
            return tiles[x][y].getSymbol();
        }
    }
    
    /**
     * Prints a version of the current level that only displays a portion of the
     * whole map centered around the player character. The amount of map 
     * displayed on the sides of the player can be adjusested.
     * 
     * @param viewX
     * @param viewY 
     * @return  
     */
    public String printConstrained(int viewX, int viewY) {
        char[][] tilesWithCharacters = new char[viewX][viewY];
        
        int origoX = playerCharacter.getPosition().getCoordX();
        int origoY = playerCharacter.getPosition().getCoordY();
        //fetching symbols that represent background tileset
        for (int j = 0; j < viewY; j++) {
            for (int i = 0; i < viewX; i++) {
                tilesWithCharacters[i][j] = tileRelativeToCharacterSymbol(origoX+i-viewX/2,origoY+j-viewY/2);
            }
        }
        //adding the player character to the map
        tilesWithCharacters[viewX/2][viewY/2] = playerCharacter.getSymbol();

        //creating a printable version of the map with both tiles and characters
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < viewY; i++) {
            for (int j = 0; j < viewX; j++) {
                sb.append(tilesWithCharacters[j][i]);
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    /**
     * Returns the error log list object.
     * 
     * @return 
     */
    public ArrayList<String> returnErrorLog() {
        return errorLog;
    }

}

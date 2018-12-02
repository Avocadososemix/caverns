/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GameLogic.Character;
import GameLogic.Level;
import GameLogic.Tile;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lkaranko
 */
public class LevelTest {
    
    private Level testLevel;
    private int sizeX, sizeY;
    private Tile[][] tiles;
    
    public LevelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        sizeX = 30;
        sizeY = 50;
        testLevel = new Level(30, 50);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSizeX method, of class Level.
     */
    @Test
    public void testGetSizeX() {
        System.out.println("getSizeX");
        int expResult = 30;
        int result = testLevel.getSizeX();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSizeY method, of class Level.
     */
    @Test
    public void testGetSizeY() {
        System.out.println("getSizeY");
        int expResult = 50;
        int result = testLevel.getSizeY();
        assertEquals(expResult, result);
    }

    /**
     * Test of initializeLevel method, of class Level.
     */
    @Test
    public void testInitializeLevel() {
        System.out.println("initializeLevel");
        testLevel.initializeLevel();
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                if (testLevel.tiles[j][i].getSymbol() != '.') {
                    fail();
                }
            }
        }
    }

    /**
     * Test of fillWithWalls method, of class Level.
     */
    @Test
    public void testFillWithWalls() {
        System.out.println("fillWithWalls");
        testLevel.fillWithWalls();
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                if (testLevel.tiles[j][i].getSymbol() != '#') {
                    fail();
                }
            }
        }
    }

    /**
     * Test of randomWalk method, of class Level. This needs more work.
     */
    @Test
    public void testRandomWalk() {
        System.out.println("randomWalk");
        testLevel.fillWithWalls();
        testLevel.randomWalk();
        for (int i = 0; i < testLevel.sizeY; i++) {
            for (int j = 0; j < testLevel.sizeX; j++) {
                if (testLevel.tiles[j][i].getSymbol() != '#') {
                    assertTrue(true);
                }
            }
        }
    }

    /**
     * Test of setWall method, of class Level.
     */
    @Test
    public void testSetWall() {
        System.out.println("setWall");
        int coordX = 1;
        int coordY = 2;
        testLevel.initializeLevel();
        testLevel.setWall(coordX, coordY);
        char symbol = '#';
        assertTrue(testLevel.getLevelTile(coordX, coordY).getSymbol() == symbol);
    }

    /**
     * Test of setEmpty method, of class Level.
     */
    @Test
    public void testSetEmpty() {
        System.out.println("setEmpty");
        int coordX = 1;
        int coordY = 2;
        testLevel.fillWithWalls();
        testLevel.setEmpty(coordX, coordY);
        char symbol = '.';
        assertTrue(testLevel.getLevelTile(coordX, coordY).getSymbol() == symbol);
    }

    /**
     * Test of moveCharacter method, of class Level.
     */
    @Test
    public void testMoveCharacter() {
        System.out.println("moveCharacter");
        Character player = new Character(0,0);
        testLevel.addCharacter(player);
        testLevel.initializeLevel();
        int moveX = 1;
        int moveY = 2;
        testLevel.moveCharacter(player, moveX, moveY);
        assertTrue(player.getPosition().getCoordX() == 0+moveX);
        assertTrue(player.getPosition().getCoordY() == 0+moveY);
    }

    /**
     * Test of directionPassable method, of class Level.
     */
    @Test
    public void testDirectionPassable() {
        System.out.println("directionPassable");
        Character testPlayer = new Character(0,0);
        testLevel.fillWithWalls();
        int moveX = 1, moveY = 1;
        boolean result = testLevel.directionPassable(testPlayer, moveX, moveY);
        assertEquals(false, result);
        testLevel.setEmpty(1,1);
        result = testLevel.directionPassable(testPlayer, moveX, moveY);
        assertEquals(true, result);
        
    }

    /**
     * Test of moveCommand method, of class Level.
     */
    @Test
    public void testMoveCommand() {
        System.out.println("moveCommand");
        String[] directions = {"n","e","s","w"};
        int[] resultsX = {1,2,2,1};
        int[] resultsY = {1,1,2,2};
        Character testPlayer = new Character(1,2);
        testLevel.initializeLevel();
        for (int i = 0; i < directions.length; i++) {
            testLevel.moveCommand(directions[i], testPlayer);
            assertTrue(testPlayer.getPosition().getCoordX() == resultsX[i]);
            assertTrue(testPlayer.getPosition().getCoordY() == resultsY[i]);
        }
    }

    /**
     * Test of addCharacter method, of class Level.
     */
    @Test
    public void testAddCharacter() {
        System.out.println("addCharacter");
        Character testPlayer = new Character();
        testLevel.addCharacter(testPlayer);
        assertTrue(testLevel.playerCharacter != null);
    }

    /**
     * Test of getLevelTile method, of class Level.
     */
    @Test
    public void testGetLevelTile() {
        System.out.println("getLevelTile");
        testLevel.fillWithWalls();
        int coordX = 3;
        int coordY = 3;
        char expResult = '#';
        Tile result = testLevel.getLevelTile(coordX, coordY);
        assertEquals(expResult, result.getSymbol());
        testLevel.setEmpty(coordX, coordY);
        assertEquals('.', result.getSymbol());
    }

    /**
     * Test of printLevel method, of class Level. Tests a level layout with 2
     * wall pieces.
     */
    @Test
    public void testPrintLevel() {
        System.out.println("printLevel");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream oldOut = System.out;
        System.setOut(new PrintStream(outContent));
        Level miniLevel = new Level(3,3);
        miniLevel.initializeLevel();
        miniLevel.setWall(1, 1);
        miniLevel.setWall(2, 2);
        miniLevel.printLevel();
        System.setOut(oldOut);
        //String level = outContent.toString();
        //System.out.println(level);
        assertEquals("...\n.#.\n..#", outContent.toString().trim());
    }

    /**
     * Test of printLevelWithCharacters method, of class Level.
     */
    @Test
    public void testPrintLevelWithCharacters() {
        System.out.println("printLevelWithCharacters");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream oldOut = System.out;
        System.setOut(new PrintStream(outContent));
        Level miniLevel = new Level(3,3);
        miniLevel.initializeLevel();
        miniLevel.setWall(1, 1);
        miniLevel.setWall(2, 2);
        Character testCharacter = new Character('@',0,0);
        miniLevel.addCharacter(testCharacter);
        miniLevel.printLevelWithCharacters();
        System.setOut(oldOut);
        //String level = outContent.toString();
        //System.out.println(level);
        assertEquals("@..\n.#.\n..#", outContent.toString().trim());
    }

    /**
     * Test of returnErrorLog method, of class Level.
     */
    @Test
    public void testReturnErrorLog() {
        System.out.println("returnErrorLog");
        String errorString = "This is an error";
        testLevel.errorLog.add(errorString);
        assertEquals(errorString, testLevel.returnErrorLog().get(0));
    }
    
}

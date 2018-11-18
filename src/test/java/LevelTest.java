/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
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
    
    private Level miniLevel;
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
        miniLevel = new Level(30, 50);
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
        int result = miniLevel.getSizeX();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSizeY method, of class Level.
     */
    @Test
    public void testGetSizeY() {
        System.out.println("getSizeY");
        int expResult = 50;
        int result = miniLevel.getSizeY();
        assertEquals(expResult, result);
    }

    /**
     * Test of initializeLevel method, of class Level.
     */
    @Test
    public void testInitializeLevel() {
        System.out.println("initializeLevel");
        miniLevel.initializeLevel();
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                if (miniLevel.tiles[j][i].getSymbol() != '.') {
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
        miniLevel.fillWithWalls();
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                if (miniLevel.tiles[j][i].getSymbol() != '#') {
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
        miniLevel.randomWalk();
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                if (miniLevel.tiles[j][i].getSymbol() != '.') {
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
        miniLevel.initializeLevel();
        miniLevel.setWall(coordX, coordY);
        char symbol = '#';
        assertTrue(miniLevel.getLevelTile(coordX, coordY).getSymbol() == symbol);
    }

    /**
     * Test of setEmpty method, of class Level.
     */
    @Test
    public void testSetEmpty() {
        System.out.println("setEmpty");
        int coordX = 1;
        int coordY = 2;
        miniLevel.fillWithWalls();
        miniLevel.setEmpty(coordX, coordY);
        char symbol = '.';
        assertTrue(miniLevel.getLevelTile(coordX, coordY).getSymbol() == symbol);
    }

    /**
     * Test of moveCharacter method, of class Level.
     */
    @Test
    public void testMoveCharacter() {
        System.out.println("moveCharacter");
        Character player = new Character(0,0);
        miniLevel.addCharacter(player);
        miniLevel.initializeLevel();
        int moveX = 1;
        int moveY = 2;
        miniLevel.moveCharacter(player, moveX, moveY);
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
        miniLevel.fillWithWalls();
        int moveX = 1, moveY = 1;
        boolean result = miniLevel.directionPassable(testPlayer, moveX, moveY);
        assertEquals(false, result);
        miniLevel.setEmpty(1,1);
        result = miniLevel.directionPassable(testPlayer, moveX, moveY);
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
        miniLevel.initializeLevel();
        for (int i = 0; i < directions.length; i++) {
            miniLevel.moveCommand(directions[i], testPlayer);
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
        Character testPlayer = new Character(0,0);
        assertTrue(miniLevel.mapObjects.isEmpty());
        miniLevel.addCharacter(testPlayer);
        assertTrue(!miniLevel.mapObjects.isEmpty());
    }

    /**
     * Test of getLevelTile method, of class Level.
     */
    @Test
    public void testGetLevelTile() {
        System.out.println("getLevelTile");
        miniLevel.fillWithWalls();
        int coordX = 3;
        int coordY = 3;
        char expResult = '#';
        Tile result = miniLevel.getLevelTile(coordX, coordY);
        assertEquals(expResult, result.getSymbol());
        miniLevel.setEmpty(coordX, coordY);
        assertEquals('.', result.getSymbol());
    }

    /**
     * Test of printLevel method, of class Level.
     */
    @Test
    public void testPrintLevel() {
        System.out.println("printLevel");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream oldOut = System.out;
        System.setOut(new PrintStream(outContent));
        Level miniLevel = new Level(0,0);
        miniLevel.initializeLevel();
        //miniLevel.setWall(3, 4);
        //iniLevel.setWall(14, 10);
        miniLevel.printLevel();
        System.setOut(oldOut);
        assertEquals(".", outContent.toString());
    }

    /**
     * Test of printLevelWithCharacters method, of class Level.
     */
    @Test
    public void testPrintLevelWithCharacters() {
        System.out.println("printLevelWithCharacters");
        Level instance = null;
        instance.printLevelWithCharacters();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnErrorLog method, of class Level.
     */
    @Test
    public void testReturnErrorLog() {
        System.out.println("returnErrorLog");
        Level instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.returnErrorLog();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

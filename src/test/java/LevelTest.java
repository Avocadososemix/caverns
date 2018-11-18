/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
        Level instance = null;
        int expResult = 0;
        int result = instance.getSizeX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSizeY method, of class Level.
     */
    @Test
    public void testGetSizeY() {
        System.out.println("getSizeY");
        Level instance = null;
        int expResult = 0;
        int result = instance.getSizeY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initializeLevel method, of class Level.
     */
    @Test
    public void testInitializeLevel() {
        System.out.println("initializeLevel");
        Level instance = null;
        instance.initializeLevel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fillWithWalls method, of class Level.
     */
    @Test
    public void testFillWithWalls() {
        System.out.println("fillWithWalls");
        Level instance = null;
        instance.fillWithWalls();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of randomWalk method, of class Level.
     */
    @Test
    public void testRandomWalk() {
        System.out.println("randomWalk");
        Level instance = null;
        instance.randomWalk();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWall method, of class Level.
     */
    @Test
    public void testSetWall() {
        System.out.println("setWall");
        int coordX = 0;
        int coordY = 0;
        Level instance = null;
        instance.setWall(coordX, coordY);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmpty method, of class Level.
     */
    @Test
    public void testSetEmpty() {
        System.out.println("setEmpty");
        int coordX = 0;
        int coordY = 0;
        Level instance = null;
        instance.setEmpty(coordX, coordY);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of moveCharacter method, of class Level.
     */
    @Test
    public void testMoveCharacter() {
        System.out.println("moveCharacter");
        Character character = null;
        int moveX = 0;
        int moveY = 0;
        Level instance = null;
        instance.moveCharacter(character, moveX, moveY);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of directionPassable method, of class Level.
     */
    @Test
    public void testDirectionPassable() {
        System.out.println("directionPassable");
        Character character = null;
        int moveX = 0;
        int moveY = 0;
        Level instance = null;
        boolean expResult = false;
        boolean result = instance.directionPassable(character, moveX, moveY);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of moveCommand method, of class Level.
     */
    @Test
    public void testMoveCommand() {
        System.out.println("moveCommand");
        String direction = "";
        Character character = null;
        Level instance = null;
        instance.moveCommand(direction, character);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCharacter method, of class Level.
     */
    @Test
    public void testAddCharacter() {
        System.out.println("addCharacter");
        Character player = null;
        Level instance = null;
        instance.addCharacter(player);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLevelTile method, of class Level.
     */
    @Test
    public void testGetLevelTile() {
        System.out.println("getLevelTile");
        int coordX = 0;
        int coordY = 0;
        Level instance = null;
        char expResult = ' ';
        char result = instance.getLevelTile(coordX, coordY);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printLevel method, of class Level.
     */
    @Test
    public void testPrintLevel() {
        System.out.println("printLevel");
        Level instance = null;
        instance.printLevel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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

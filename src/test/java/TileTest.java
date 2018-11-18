/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class TileTest {
    
    public TileTest() {
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
     * Test of getSymbol method, of class Tile.
     */
    @Test
    public void testGetSymbol() {
        System.out.println("getSymbol");
        Tile instance = null;
        char expResult = ' ';
        char result = instance.getSymbol();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSymbol method, of class Tile.
     */
    @Test
    public void testSetSymbol() {
        System.out.println("setSymbol");
        char symbol = ' ';
        Tile instance = null;
        instance.setSymbol(symbol);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassable method, of class Tile.
     */
    @Test
    public void testGetPassable() {
        System.out.println("getPassable");
        Tile instance = null;
        boolean expResult = false;
        boolean result = instance.getPassable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassable method, of class Tile.
     */
    @Test
    public void testSetPassable() {
        System.out.println("setPassable");
        boolean passable = false;
        Tile instance = null;
        instance.setPassable(passable);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

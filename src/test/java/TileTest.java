/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GameLogic.Tile;
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
        Tile instance = new Tile('.');
        char expResult = '.';
        char result = instance.getSymbol();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSymbol method, of class Tile.
     */
    @Test
    public void testSetSymbol() {
        System.out.println("setSymbol");
        char symbol = '.';
        Tile instance = new Tile('#');
        instance.setSymbol(symbol);
        assertEquals(symbol, instance.getSymbol());
    }

    /**
     * Test of getPassable method, of class Tile.
     */
    @Test
    public void testGetPassable() {
        System.out.println("getPassable");
        Tile instance = new Tile('.');
        boolean expResult = true;
        boolean result = instance.getPassable();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassable method, of class Tile.
     */
    @Test
    public void testSetPassable() {
        System.out.println("setPassable");
        boolean passable = false;
        Tile instance = new Tile('#');
        instance.setPassable(passable);
        assertEquals(passable, instance.getPassable());
    }
    
}

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
public class CoordinatesTest {
    
    private Coordinates testInstance;
    
    public CoordinatesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testInstance = new Coordinates(3,4);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCoordX method, of class Coordinates.
     */
    @Test
    public void testGetCoordX() {
        System.out.println("getCoordX");
        int expResult = 3;
        int result = testInstance.getCoordX();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCoordX method, of class Coordinates.
     */
    @Test
    public void testSetCoordX() {
        System.out.println("setCoordX");
        int coordX = 0;
        testInstance.setCoordX(coordX);
        assertEquals(coordX, testInstance.getCoordX());
    }

    /**
     * Test of getCoordY method, of class Coordinates.
     */
    @Test
    public void testGetCoordY() {
        System.out.println("getCoordY");
        int expResult = 4;
        int result = testInstance.getCoordY();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCoordY method, of class Coordinates.
     */
    @Test
    public void testSetCoordY() {
        System.out.println("setCoordY");
        int coordY = 0;
        testInstance.setCoordY(coordY);
        assertEquals(coordY, testInstance.getCoordY());
    }

    /**
     * Test of setCoordXY method, of class Coordinates.
     */
    @Test
    public void testSetCoordXY() {
        System.out.println("setCoordXY");
        int coordX = 5;
        int coordY = 6;
        testInstance.setCoordXY(coordX, coordY);
        assertEquals(coordX, testInstance.getCoordX());
        assertEquals(coordY, testInstance.getCoordY());
    }
    
}

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
        Coordinates instance = null;
        int expResult = 0;
        int result = instance.getCoordX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCoordX method, of class Coordinates.
     */
    @Test
    public void testSetCoordX() {
        System.out.println("setCoordX");
        int coordX = 0;
        Coordinates instance = null;
        instance.setCoordX(coordX);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCoordY method, of class Coordinates.
     */
    @Test
    public void testGetCoordY() {
        System.out.println("getCoordY");
        Coordinates instance = null;
        int expResult = 0;
        int result = instance.getCoordY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCoordY method, of class Coordinates.
     */
    @Test
    public void testSetCoordY() {
        System.out.println("setCoordY");
        int coordY = 0;
        Coordinates instance = null;
        instance.setCoordY(coordY);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCoordXY method, of class Coordinates.
     */
    @Test
    public void testSetCoordXY() {
        System.out.println("setCoordXY");
        int coordX = 0;
        int coordY = 0;
        Coordinates instance = null;
        instance.setCoordXY(coordX, coordY);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

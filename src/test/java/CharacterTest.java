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
public class CharacterTest {
    
    public CharacterTest() {
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
     * Test of getSymbol method, of class Character.
     */
    @Test
    public void testGetSymbol() {
        System.out.println("getSymbol");
        Character instance = new Character();
        char expResult = ' ';
        char result = instance.getSymbol();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSymbol method, of class Character.
     */
    @Test
    public void testSetSymbol() {
        System.out.println("setSymbol");
        char symbol = ' ';
        Character instance = new Character();
        instance.setSymbol(symbol);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosition method, of class Character.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        Character instance = new Character();
        Coordinates expResult = null;
        Coordinates result = instance.getPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosition method, of class Character.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        int posX = 0;
        int posY = 0;
        Character instance = new Character();
        instance.setPosition(posX, posY);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of movePosition method, of class Character.
     */
    @Test
    public void testMovePosition() {
        System.out.println("movePosition");
        int posX = 0;
        int posY = 0;
        Character instance = new Character();
        instance.movePosition(posX, posY);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

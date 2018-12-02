/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GameLogic.Character;
import GameLogic.Coordinates;
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
        Character testChar1 = new Character();
        Character testChar2 = new Character('@', 1, 2);
        char expResult = '@';
        char result1 = testChar1.getSymbol();
        char result2 = testChar2.getSymbol();
        assertEquals(expResult, result1);
        assertEquals(expResult, result2);
    }

    /**
     * Test of setSymbol method, of class Character.
     */
    @Test
    public void testSetSymbol() {
        System.out.println("setSymbol");
        char symbol = 'K';
        Character testCharacter = new Character(symbol, 1, 2);
        testCharacter.setSymbol(symbol);
        assertEquals(symbol, testCharacter.getSymbol());
    }

    /**
     * Test of getPosition method, of class Character.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        Character testCharacter1 = new Character();
        Character testCharacter2 = new Character(3,4);
        Coordinates expResult1 = new Coordinates(0,0);
        Coordinates expResult2 = new Coordinates(3,4);
        assertEquals(expResult1.getCoordX(), (testCharacter1.getPosition().getCoordX()));
        assertEquals(expResult1.getCoordY(), (testCharacter1.getPosition().getCoordY()));
        assertEquals(expResult2.getCoordX(), (testCharacter2.getPosition().getCoordX()));
        assertEquals(expResult2.getCoordY(), (testCharacter2.getPosition().getCoordY()));
    }

    /**
     * Test of setPosition method, of class Character.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        int posX = 5;
        int posY = 3;
        Coordinates coord = new Coordinates(posX, posY);
        Character testCharacter = new Character();
        testCharacter.setPosition(posX, posY);
        assertEquals(coord.getCoordX(), testCharacter.getPosition().getCoordX());
        assertEquals(coord.getCoordY(), testCharacter.getPosition().getCoordY());
    }

    /**
     * Test of movePosition method, of class Character.
     */
    @Test
    public void testMovePosition() {
        System.out.println("movePosition");
        int posX = 1;
        int posY = -1;
        Coordinates coord = new Coordinates(2, 1);
        Character testCharacter = new Character(1,2);
        testCharacter.movePosition(posX, posY);
        assertEquals(coord.getCoordX(), testCharacter.getPosition().getCoordX());
        assertEquals(coord.getCoordY(), testCharacter.getPosition().getCoordY());
    }
    
}

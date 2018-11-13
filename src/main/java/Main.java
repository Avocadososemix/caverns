
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lkaranko
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("Welcome to level 1");
        Level starter = new Level(30, 6); //creating a new level
        starter.initializeLevel(); //filling level with empty tiles
        System.out.println("");
        
        Character player = new Character();
        player.setPosition(4, 4);
        starter.addCharacter(player); //adding the player character to the level

        //Testing adding a few walls
        starter.setWall(2, 2);
        starter.setWall(2, 3);

//        Testing JPanel view, later program will be run in the panel
//        Screen window = new Screen();
//        //Check individual tile
//        char foundChar = starter.getLevelTile(2, 2);
//        System.out.println(foundChar);
//        
        //Print Level
        Scanner scan = new Scanner(System.in);
        String input = "";
        while (true) {
            starter.printLevelWithCharacters();
            System.out.println("Select direction to move: ");
            input = scan.nextLine();
            if (input.trim().contains("end")) {
                System.out.println("Bye!");
                break;
            }
            starter.moveCommand(input, player);
        }
    }
    
}

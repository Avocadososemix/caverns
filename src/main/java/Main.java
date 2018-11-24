
import javafx.application.Application;
import java.io.IOException;
import java.util.Scanner;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lkaranko
 */
public class Main extends Application {

    public void start(Stage primaryStage) throws IOException {
        Parent root = setScene(primaryStage);
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cavern Explorer");
        primaryStage.show();
    }

    private Parent setScene(Stage PrimaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI.fxml"));
        Parent root = loader.load();
        return root;
    }

    public static void main(String[] args) {
        launch(args);
        System.out.println("Welcome to level 1");
        Level starter = new Level(80, 30); //creating a new level
        //starter.initializeLevel(); //filling level with empty tiles
        starter.fillWithWalls(); //filling level with walls
        starter.randomWalk(); //creating a random cavern
        starter.randomWalk(); //creating a random cavern
        starter.randomWalk(); //creating a random cavern
        System.out.println("");

        Character player = new Character();
        player.setPosition(40, 15);
        starter.addCharacter(player); //adding the player character to the level

        //Testing adding a few walls
        //starter.setWall(2, 2);
        //starter.setWall(2, 3);
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
            starter.printConstrained(48,17);
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

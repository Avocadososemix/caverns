
import javafx.application.Application;
import java.io.IOException;
import java.util.Scanner;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JFileChooser;

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
        Parent root = startGame(primaryStage);
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cavern Explorer");
        primaryStage.show();
    }

    private Parent startGame(Stage PrimaryStage) throws IOException {
        Level level = new Level(60, 60);
        Character player = new Character(0, 0);

        //Parent root = new StackPane();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI.fxml"));
        Parent root = loader.load();
        //FXMLLoader fxmlLoader = new FXMLLoader( getClass().getResource("/main.fxml") );
        //Parent root = new FXMLLoader.load(getClass().getResource("/GUI.fxml"));
        //Parent root = (Parent) loader.load();
        return root;
    }

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        System.out.println("getCurrentDirectory(): "
                + chooser.getCurrentDirectory());

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
            starter.printConstrained(16,32);
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

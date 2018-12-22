

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import BinarySpacePartition.BinarySpacePartition;
import GameLogic.Character;
import GameLogic.Level;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 * This class controls the use of the GUI. All level data is loaded in the
 * constructor. This class contains all actions that the user employs to 
 * manipulate the GUI, which then call methods in the Level class.
 * 
 * @author lkaranko
 */
    public class GUIController implements Initializable {

    private Level starter;
    private final Character player;
    private String statusMessage;

    @FXML
    private Label screenOutput, message;
    @FXML
    private Button west, east, north, south;
    /**
     * Actionhandlers that receive move calls from the GUI.
     * @param event 
     */
    @FXML
    private void handleButtonActionEast(ActionEvent event) {
        statusMessage = starter.moveCommand("E", player);
        screenPrint();
    }

    @FXML
    private void handleButtonActionSouth(ActionEvent event) {
        statusMessage = starter.moveCommand("S", player);
        screenPrint();
    }

    @FXML
    private void handleButtonActionWest(ActionEvent event) {
        statusMessage = starter.moveCommand("W", player);
        screenPrint();
    }

    @FXML
    private void handleButtonActionNorth(ActionEvent event) {
        statusMessage = starter.moveCommand("N", player);
        screenPrint();
    }

    /**
     * The level and characters are loaded into the class in the constructor.
     */
    public GUIController() {
        starter = new Level(80, 80); //creating a new level
        starter.fillWithWalls(); //filling level with walls
        BinarySpacePartition BSP = new BinarySpacePartition(6);
        starter = BSP.generateBSP(starter);
        //starter.randomWalk(); //creating a random cavern
        //starter.randomWalk(); //creating a random cavern
        starter.randomWalk(); //creating a random cavern
        player = new Character(40,40);
        starter.addCharacter(player); //adding the player character to the level
    }

    /**
     * Method used to print all information that changes on the GUI.
     */
    public void screenPrint() {
        screenOutput.setText(starter.printConstrained(48, 17));
        screenOutput.setFont(Font.font(java.awt.Font.MONOSPACED, 15));
        message.setText(statusMessage);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        starter.printConstrained(48, 17);
    }

}

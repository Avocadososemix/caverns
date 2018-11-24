/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 *
 * @author lkaranko
 */
    public class GUIController implements Initializable {

    private Level starter;
    private final Character player;
    private String statusMessage;

    @FXML
    private Label screenOutput;
    @FXML
    private Button west;
    @FXML
    private Button north;
    @FXML
    private Button south;
    @FXML
    private Button east;
    @FXML
    private Label message;

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

    public GUIController() {
        starter = new Level(80, 80); //creating a new level
        starter.fillWithWalls(); //filling level with walls
        starter.randomWalk(); //creating a random cavern
        starter.randomWalk(); //creating a random cavern
        starter.randomWalk(); //creating a random cavern
        player = new Character();
        player.setPosition(40, 40);
        starter.addCharacter(player); //adding the player character to the level
    }

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

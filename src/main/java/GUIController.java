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
    
    @FXML
    private Label label;
        
    @FXML
    private Label screenOutput;
    
    @FXML
    private Button west;
    
    @FXML
    private void handleButtonActionEast(ActionEvent event) {
        System.out.println("You clicked me!");
        screenPrint();
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
        
    public void buttonClickEast() {
        screenPrint();
    }
    
    
    public void screenPrint() {
        screenOutput.setText("#########################...#####......#########################################\n" +
"####################.......#####.........###....################################\n" +
"####################..##.....#######.........#.#################################\n" +
"###################.........#####..........#....################################\n" +
"###################................###.#...........#############################\n" +
"###################.....................#........#.#############################\n" +
"################.###....##......#..................#############################\n" +
"###############....###...#............#..........###############################\n" +
"##############.................................#################################\n" +
"##############.....#...........................#################################\n" +
"########.###..................#########.......##################################\n" +
"########..#..#................#..............######This is a test  #############\n" +
"########.....#................................##################################\n" +
"######...............................#.....######I'm a placeholder##############\n" +
"####......................##..................##################################\n" +
"###.....................................@.....###The new methods to print the ##\n" +
"##...........................................###################################\n" +
"##..##.......#.....##..........##################level will be used here soon###\n" +
".........#############..........################################################\n" +
"##...################...........################################################\n" +
"#....####################.....#..###############################################\n" +
"###.#########################.#.################################################\n" +
"#############################...################################################\n" +
"################################################################################\n" +
"#####Close this window to get to the console version of the program :)##########\n" +
"################################################################################\n" +
"################################################################################\n" +
"################################################################################\n" +
"################################################################################\n" +
"################################################################################");
        screenOutput.setFont(Font.font(java.awt.Font.MONOSPACED, 15));
    }
    
}


import BinarySpacePartition.BinarySpacePartition;
import GameLogic.Level;
import javafx.application.Application;
import java.io.IOException;
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

    /**
     * This method creates the Javafx panel for the program.
     * 
     * @param primaryStage
     * @throws IOException 
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = setScene(primaryStage);
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cavern Explorer");
        primaryStage.show();
    }

    /**
     * Loads the FXML for the GUI, and returns it to the Scene setting method.
     * 
     * @param PrimaryStage
     * @return
     * @throws IOException 
     */
    private Parent setScene(Stage PrimaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI.fxml"));
        Parent root = loader.load();
        return root;
    }

    public static void main(String[] args) {
        Level level = new Level(5,5);
        BinarySpacePartition part = new BinarySpacePartition(level.tiles);
        part.bisectTable();
        
        
        //launch(args);
    }

}

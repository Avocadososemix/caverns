
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
    }

}

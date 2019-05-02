package org.openjfx;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.HashMap;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Vikarbyrå - Forside");
        stage.setScene(scene);
        stage.show();
    }
/*
    public void SceneController(String fxmlFil){
       HashMap<String, Pane> screen = new HashMap<>();
    }
*/
    public static void main(String[] args) {
        launch(args);
    }

}

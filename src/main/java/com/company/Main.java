package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(getClass().getResource("/com/company/Interface.fxml"));
        //Det under funker, men gir ikke autofill i scene builder(når Interface.fxml ligger under resources).
        //fxmlloader.setLocation(getClass().getResource("Interface.fxml"));
        Pane hovedPane = fxmlloader.load();
        Scene hovedScene = new Scene(hovedPane, 300, 275);
        primaryStage.setScene(hovedScene);
        primaryStage.setTitle("Vikarbyrå");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

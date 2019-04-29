package org.openjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class JobbsokerController {


    //Metode for scenebytte til HovedScenen
    public void byttSceneHoved(ActionEvent event) throws IOException {
        Parent HovedParent = FXMLLoader.load(getClass().getResource("scene.fxml"));
        Scene HovedScene = new Scene(HovedParent);

        //henter stage informasjon
        Stage HovedStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        HovedStage.setScene(HovedScene);
        HovedStage.show();
    }

    //Metode for scenebytte til Arbeidsgiver
    public void byttSceneArbeidsgiver(ActionEvent event) throws IOException {
        Parent ArbeidsgiverParent = FXMLLoader.load(getClass().getResource("Arbeidsgiver.fxml"));
        Scene ArbeidsgiverScene = new Scene(ArbeidsgiverParent);

        //henter stage informasjon
        Stage ArbeidsgiverStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ArbeidsgiverStage.setScene(ArbeidsgiverScene);
        ArbeidsgiverStage.setTitle("Vikarbyrå - Arbeidsgiver");
        ArbeidsgiverStage.show();
    }

    //Metode for scenebytte til vikariat
    public void byttSceneVikariat(ActionEvent event) throws IOException {
        Parent VikariatParent = FXMLLoader.load(getClass().getResource("Arbeidsgiver.fxml"));
        Scene VikariatScene = new Scene(VikariatParent);

        //henter stage informasjon
        Stage VikariatStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        VikariatStage.setScene(VikariatScene);
        VikariatStage.setTitle("Vikarbyrå - Vikariat");
        VikariatStage.show();
    }
}

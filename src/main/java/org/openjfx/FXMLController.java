package org.openjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import lagring.FileSaveStrategy;
import modeller.Arbeidsgiver;
import modeller.Jobbsoker;
import modeller.LedigeVikariater;

import java.io.IOException;

public class FXMLController {

    @FXML
    private ListView<String> listView;

    public void initialize() {
        if(FileSaveStrategy.objList.size() > 0){

            for(int i = 0; i < FileSaveStrategy.objList.size(); i++) {
                Object o = FileSaveStrategy.objList.get(i);
                if(o instanceof Jobbsoker){
                    Jobbsoker jobs = (Jobbsoker) o;
                    Jobbsoker.Jobbsokermodell data = jobs.data();
                    String info = String.join(" | ", data.getEnavn(), data.getFnavn(),
                            data.getAlder(), data.getEmail(), data.getErfaring(),
                            data.getJobbKat(), data.getLønnKrav(), data.getTlf(),
                            data.getRef());
                    System.out.println(info);
                    listView.getItems().add(info);
                }else if(o instanceof Arbeidsgiver){
                    Arbeidsgiver arb = (Arbeidsgiver) o;
                    Arbeidsgiver.Arbeidsmodell data = arb.data();
                    String info = String.join(" | ", data.getAdresse(),
                            data.getBransje(), data.getEmail(), data.getTlf());
                    listView.getItems().add(info);
                }else if(o instanceof LedigeVikariater){

                }
            }
        }
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

    //Metode for scenebytte til Jobbsøker
    public void byttSceneJobbsoker(ActionEvent event) throws IOException {
        Parent JobbsokerParent = FXMLLoader.load(getClass().getResource("Jobbsoker.fxml"));
        Scene JobbsokerScene = new Scene(JobbsokerParent);

        //henter stage informasjon
        Stage JobbsokerStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        JobbsokerStage.setScene(JobbsokerScene);
        JobbsokerStage.setTitle("Vikarbyrå - Jobbsøker");
        JobbsokerStage.show();
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

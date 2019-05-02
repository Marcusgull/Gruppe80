package org.openjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lagring.FileSaveCSV;
import lagring.FileSaveContext;
import lagring.FileSaveStrategy;
import modeller.LedigeVikariater;

import java.io.IOException;

public class VikariatController {
    @FXML
    private ListView<LedigeVikariater> listView;
    @FXML
    private TextField sektor;
    @FXML
    private TextField sted;
    @FXML
    private TextField arbeidsgiver;
    @FXML
    private TextField jobbkategori;
    @FXML
    private TextField varighet;
    @FXML
    private TextField arbeidstid;
    @FXML
    private TextField stillingstype;
    @FXML
    private TextField kvalifikasjoner;

    public void initialize(){
        if(FileSaveStrategy.objList.size() > 0){
            for(int i = 0; i < FileSaveStrategy.objList.size(); i++){
                if(FileSaveStrategy.objList.get(i) instanceof LedigeVikariater){
                    LedigeVikariater a =(LedigeVikariater) FileSaveStrategy.objList.get(i);
                    listView.getItems().add(a);
                }
            }
        }
    }

    public void leggTil() {
        LedigeVikariater ledigeVikariater = new LedigeVikariater();
        ledigeVikariater.Sektor.setValue(sektor.getText());
        ledigeVikariater.Sted.setValue(sted.getText());
        ledigeVikariater.Arbeidsgiver.setValue(arbeidsgiver.getText());
        ledigeVikariater.Jobbkategori.setValue(jobbkategori.getText());
        ledigeVikariater.Varighet.setValue(varighet.getText());
        ledigeVikariater.Arbeidstid.setValue(arbeidstid.getText());
        ledigeVikariater.Stillingstype.setValue(stillingstype.getText());
        ledigeVikariater.Kvalifikasjoner.setValue(kvalifikasjoner.getText());
        listView.getItems().add(ledigeVikariater);
        FileSaveStrategy.objList.add(ledigeVikariater);
    }
    public void saveObjectCSV(ActionEvent event) throws IOException {
        Stage mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FileSaveContext fileSaveContext = new FileSaveContext(new FileSaveCSV());
        fileSaveContext.lagreTilFil(mainStage, listView.getItems()
                .get(listView.getSelectionModel().getSelectedIndex()));
    }
    //bytter scene til forsiden
    public void byttSceneHoved(ActionEvent event) throws IOException {
        Parent hovedParent = FXMLLoader.load(getClass().getResource("scene.fxml"));
        Scene JobbsokerScene = new Scene(hovedParent);

        //henter stage informasjon
        Stage hovedStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        hovedStage.setScene(JobbsokerScene);
        hovedStage.setTitle("Vikarbyrå - Forside");
        hovedStage.show();
    }

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
}

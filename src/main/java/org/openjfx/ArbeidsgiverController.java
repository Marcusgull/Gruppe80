package org.openjfx;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lagring.FileLoadCSV;
import lagring.FileSaveCSV;
import lagring.FileSaveContext;
import lagring.FileSaveStrategy;
import modeller.Arbeidsgiver;

import java.io.*;

public class ArbeidsgiverController {
    @FXML
    private ListView<Arbeidsgiver> listView;

    @FXML
    private TextField adresse;
    @FXML
    private TextField bransje;
    @FXML
    private TextField email;
    @FXML
    private TextField tlf;

    public void initialize(){
        if(FileSaveStrategy.objList.size() > 0){
            for(int i = 0; i < FileSaveStrategy.objList.size(); i++){
                if(FileSaveStrategy.objList.get(i) instanceof Arbeidsgiver){
                    Arbeidsgiver a =(Arbeidsgiver) FileSaveStrategy.objList.get(i);
                    listView.getItems().add(a);
                }
            }
        }
    }

    public void leggTil() {
        Arbeidsgiver arbeidsgiver = new Arbeidsgiver();
        arbeidsgiver.Adresse.setValue(adresse.getText());
        arbeidsgiver.Bransje.setValue(bransje.getText());
        arbeidsgiver.Email.setValue(email.getText());
        arbeidsgiver.Tlf.setValue(tlf.getText());
        listView.getItems().add(arbeidsgiver);
        FileSaveStrategy.objList.add(arbeidsgiver);
    }

    public void saveObjectCSV(ActionEvent event) throws IOException {
        Stage mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FileSaveContext fileSaveContext = new FileSaveContext(new FileSaveCSV());
        fileSaveContext.lagreTilFil(mainStage, listView.getItems()
                .get(listView.getSelectionModel().getSelectedIndex()));

    }

    public void saveObjectJOBJ() {
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
        Parent VikariatParent = FXMLLoader.load(getClass().getResource("Vikariat.fxml"));
        Scene VikariatScene = new Scene(VikariatParent);

        //henter stage informasjon
        Stage VikariatStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        VikariatStage.setScene(VikariatScene);
        VikariatStage.setTitle("Vikarbyrå - Vikariat");
        VikariatStage.show();
    }
}

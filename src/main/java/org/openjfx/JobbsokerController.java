package org.openjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lagring.FileSaveCSV;
import lagring.FileSaveContext;
import modeller.Jobbsoker;

import java.io.IOException;

public class JobbsokerController {

    @FXML
    private ListView<Jobbsoker> listView;

    @FXML
    private TextField fnavn;
    @FXML
    private TextField enavn;
    @FXML
    private TextField tlf;
    @FXML
    private TextField email;
    @FXML
    private TextField alder;
    @FXML
    private TextField jobbKat;
    @FXML
    private TextField erfaring;
    @FXML
    private TextField lonnsKrav;
    @FXML
    private TextField ref;

    public void leggTil() {
        Jobbsoker jobbsoker = new Jobbsoker();
        jobbsoker.fnavn.setValue(fnavn.getText());
        jobbsoker.enavn.setValue(enavn.getText());
        jobbsoker.tlf.setValue(tlf.getText());
        jobbsoker.email.setValue(email.getText());
        jobbsoker.alder.setValue(alder.getText());
        jobbsoker.jobbKat.setValue(jobbKat.getText());
        jobbsoker.erfaring.setValue(erfaring.getText());
        jobbsoker.lonnsKrav.setValue(lonnsKrav.getText());
        jobbsoker.ref.setValue(ref.getText());
        listView.getItems().add(jobbsoker);
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
        Parent VikariatParent = FXMLLoader.load(getClass().getResource("Vikariat.fxml"));
        Scene VikariatScene = new Scene(VikariatParent);

        //henter stage informasjon
        Stage VikariatStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        VikariatStage.setScene(VikariatScene);
        VikariatStage.setTitle("Vikarbyrå - Vikariat");
        VikariatStage.show();
    }

}

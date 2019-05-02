package org.openjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lagring.FileSaveCSV;
import lagring.FileSaveContext;
import lagring.FileSaveStrategy;
import modeller.Arbeidsgiver;
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
    @FXML
    private Label alert;

    public void initialize(){
        if(FileSaveStrategy.objList.size() > 0){
            for(int i = 0; i < FileSaveStrategy.objList.size(); i++){
                if(FileSaveStrategy.objList.get(i) instanceof Jobbsoker){
                    Jobbsoker a =(Jobbsoker) FileSaveStrategy.objList.get(i);
                    listView.getItems().add(a);
                }
            }
        }

        if(FileSaveStrategy.redig != null){
            Jobbsoker j = (Jobbsoker) FileSaveStrategy.redig;
            enavn.setText(j.data().getEnavn());
            fnavn.setText(j.data().getFnavn());
            tlf.setText(j.data().getTlf());
            email.setText(j.data().getEmail());
            alder.setText(j.data().getAlder());
            jobbKat.setText(j.data().getJobbKat());
            erfaring.setText(j.data().getErfaring());
            lonnsKrav.setText(j.data().getLønnKrav());
            ref.setText(j.data().getRef());
        }
    }

    public void leggTil(ActionEvent e) throws IOException {
        if(FileSaveStrategy.redig != null){
            redigerer(e);
            return;
        }

        if(fnavn.getText().equals("") || enavn.getText().equals("")
                || tlf.getText().equals("")
                || email.getText().equals("")
                || alder.getText().equals("")
                || erfaring.getText().equals("")
                || lonnsKrav.getText().equals("")
                || ref.getText().equals("")){
            alert.setText("Må fylle ut alle felter!");
            return;
        }
        alert.setText("");
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
        FileSaveStrategy.objList.add(jobbsoker);
    }

    public void redigerer(ActionEvent e) throws IOException {
        FileSaveStrategy.lagrede.remove(FileSaveStrategy.redig);
        Jobbsoker j = new Jobbsoker();
        j.enavn.setValue(enavn.getText());
        j.fnavn.setValue(fnavn.getText());
        j.tlf.setValue(tlf.getText());
        j.email.setValue(email.getText());
        j.alder.setValue(alder.getText());
        j.jobbKat.setValue(jobbKat.getText());
        j.erfaring.setValue(erfaring.getText());
        j.lonnsKrav.setValue(lonnsKrav.getText());
        j.ref.setValue(ref.getText());
        FileSaveStrategy.lagrede.add(j);
        byttSceneHoved(e);
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

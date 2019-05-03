package org.openjfx;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import lagring.FileLoadCSV;
import lagring.FileSaveJOBJ;
import lagring.FileSaveStrategy;
import modeller.Arbeidsgiver;
import modeller.Jobbsoker;
import modeller.LedigeVikariater;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FXMLController {

    @FXML
    private ListView<String> listView;

    @FXML
    private ListView<String> listView1;

    public void slett(){
        Object slett = matcher();
        listView.getItems().remove(listView.getSelectionModel().getSelectedItem());
        FileSaveStrategy.lagrede.remove(slett);
        listeLagrer();
    }

    public void rediger(ActionEvent e) throws IOException {
        Object obj = matcher();

        if(obj == null) {
            System.out.println("Finner ikke match");
            return;
        }

        FileSaveStrategy.redig = obj;
        if(obj instanceof Arbeidsgiver){
            byttSceneArbeidsgiver(e);
        }else if(obj instanceof Jobbsoker){
            byttSceneJobbsoker(e);
        }else if(obj instanceof LedigeVikariater){
            byttSceneVikariat(e);
        }
    }

    public Object matcher() {
        String k = listView.getSelectionModel().getSelectedItem();
        for (int i = 0; i < FileSaveStrategy.lagrede.size(); i++){
            Object obj = FileSaveStrategy.lagrede.get(i);
            if(obj instanceof Arbeidsgiver){
                Arbeidsgiver a = (Arbeidsgiver) obj;
                if(k.equals(a.data().hentString())){
                    return a;
                }
            }else if(obj instanceof Jobbsoker){
                Jobbsoker j = (Jobbsoker) obj;
                if(k.equals(j.data().hentString())){
                    return j;
                }
            }else if(obj instanceof  LedigeVikariater){
                LedigeVikariater lv = (LedigeVikariater) obj;
                if(k.equals(lv.data().hentString())){
                    return lv;
                }
            }
        }
        return null;
    }

    public void listeLagrer(){
        try{
            FileWriter fw = new FileWriter("src/lagring.csv", false);
            for(int i = 0; i < FileSaveStrategy.lagrede.size(); i++){
                Object obj = FileSaveStrategy.lagrede.get(i);

                if (obj instanceof Arbeidsgiver) {
                    String A = "Arbeidsgiver";
                    Arbeidsgiver a = (Arbeidsgiver) obj;
                    String join = String.join(";"
                            , A
                            , a.data().getAdresse()
                            , a.data().getBransje()
                            , a.data().getEmail()
                            , a.data().getTlf() + "\n");
                    fw.append(join);
                } else if (obj instanceof Jobbsoker) {
                    Jobbsoker j = (Jobbsoker) obj;
                    String J = "Jobbsøker";
                    String join = String.join(";"
                            , J
                            , j.data().getEnavn()
                            , j.data().getFnavn()
                            , j.data().getTlf()
                            , j.data().getEmail()
                            , j.data().getAlder()
                            , j.data().getJobbKat()
                            , j.data().getLønnKrav()
                            , j.data().getErfaring()
                            , j.data().getRef() + "\n");
                    fw.append(join);
                } else if (obj instanceof LedigeVikariater) {
                    LedigeVikariater LV = (LedigeVikariater) obj;
                    String lv = "Ledige Vikariater";
                    String join = String.join(";"
                            , lv
                            , LV.data().getSektor()
                            , LV.data().getSted()
                            , LV.data().getArbeidsgiver()
                            , LV.data().getJobbkategori()
                            , LV.data().getVarighet()
                            , LV.data().getArbeidstid()
                            , LV.data().getStillingstype()
                            , LV.data().getKvalifikasjoner() + "\n");
                    fw.append(join);
                }
            }
            fw.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void initialize() {

        if(FileSaveStrategy.redig != null){
            listeLagrer();
            FileSaveStrategy.redig = null;
        }

        FileLoadCSV s = new FileLoadCSV();
        FileSaveStrategy.lagrede = s.load();


        if(FileSaveStrategy.lagrede.size() > 0){

            for(int i = 0; i < FileSaveStrategy.lagrede.size(); i++) {
                Object o = FileSaveStrategy.lagrede.get(i);
                if(o instanceof Jobbsoker){
                    Jobbsoker jobs = (Jobbsoker) o;
                    String info = jobs.data().hentString();
                    listView.getItems().add(info);
                }else if(o instanceof Arbeidsgiver){
                    Arbeidsgiver arb = (Arbeidsgiver) o;
                    String info = arb.data().hentString();
                    listView.getItems().add(info);
                }else if(o instanceof LedigeVikariater){
                    LedigeVikariater lv = (LedigeVikariater) o;
                    String info = lv.data().hentString();
                    listView.getItems().add(info);
                }
            }
        }

        /*FileSaveJOBJ jobj = new FileSaveJOBJ();
        jobj.Deserialisering();

        if(FileSaveStrategy.jobjLagrede.size() > 0){
            for(int i = 0; i < FileSaveStrategy.jobjLagrede.size(); i++){
                Object obj = FileSaveStrategy.jobjLagrede.get(i);
                if(obj instanceof Arbeidsgiver){
                    Arbeidsgiver ab = (Arbeidsgiver) obj;
                    String info = ab.data().hentString();
                    listView1.getItems().add(info);
                }
            }
        }*/
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
        Parent VikariatParent = FXMLLoader.load(getClass().getResource("Vikariat.fxml"));
        Scene VikariatScene = new Scene(VikariatParent);

        //henter stage informasjon
        Stage VikariatStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        VikariatStage.setScene(VikariatScene);
        VikariatStage.setTitle("Vikarbyrå - Vikariat");
        VikariatStage.show();
    }
}

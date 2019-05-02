package lagring;

import javafx.stage.Stage;
import modeller.Arbeidsgiver;
import modeller.Jobbsoker;
import modeller.LedigeVikariater;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;


public abstract class FileSaveStrategy {
    abstract void lagre (Stage stage, Object obj);

    public void LagreInnholdTilFil(File fil, Object obj){
        try{
            FileWriter fw = new FileWriter(fil, true);
            if(obj instanceof Arbeidsgiver){
                String A = "Arbeidsgiver";
                Arbeidsgiver a = (Arbeidsgiver) obj;
                String join = String.join(";"
                        , A
                        , a.data().getAdresse()
                        , a.data().getBransje()
                        , a.data().getEmail()
                        , a.data().getTlf() + "\n");
                fw.write(join);
            }
            if(obj instanceof Jobbsoker) {
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
                fw.write(join);
            }
            if(obj instanceof LedigeVikariater) {
                LedigeVikariater LV = (LedigeVikariater) obj;
                String lv = "Ledige Vikariater";
                String join = String.join(";"
                        ,lv
                        , LV.data().getSektor()
                        , LV.data().getSted()
                        , LV.data().getArbeidsgiver()
                        , LV.data().getJobbkategori()
                        , LV.data().getVarighet()
                        , LV.data().getArbeidstid()
                        , LV.data().getStillingstype()
                        , LV.data().getKvalifikasjoner() + "\n");
                fw.write(join);
            }
            fw.close();
        }
        catch (IOException e){
            System.out.println("en error");
        }
    }
}
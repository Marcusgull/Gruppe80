package lagring;

import javafx.stage.Stage;
import modeller.Arbeidsgiver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;


public abstract class FileSaveStrategy {
    abstract void lagre (Stage stage, Object obj);

    public void LagreInnholdTilFil(File fil, Object obj){
        File datafil = new File("/src/lagring.csv");
        try{
            datafil.createNewFile();
            //PrintWriter printWriter = new PrintWriter(fil);
            FileWriter fw = new FileWriter(datafil, true);
            if(obj instanceof Arbeidsgiver){
                Arbeidsgiver a = (Arbeidsgiver) obj;
                fw.append(a.data().getAdresse());
                fw.append(a.data().getBransje());
                fw.append(a.data().getTlf());
                fw.append(a.data().getEmail());
                fw.close();
            }
        }
        catch (IOException e){
            System.out.println("en error");
        }
    }
}
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
        try{
            FileWriter fw = new FileWriter(fil, true);
            if(obj instanceof Arbeidsgiver){
                Arbeidsgiver a = (Arbeidsgiver) obj;
                String join = String.join(";", a.data().getAdresse()
                        , a.data().getBransje()
                        , a.data().getEmail()
                        , a.data().getTlf() + "\n");
                fw.write(join);

            }
            fw.close();
        }
        catch (IOException e){
            System.out.println("en error");
        }
    }
}